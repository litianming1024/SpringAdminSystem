package cn.godbol.common.controller.api;

import cn.godbol.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by li on 17-3-14.
 */
public interface DefaultSaveController<T, ID extends Serializable, DTO> extends SaveController<T, ID, DTO> {


    //由于使用泛型带来了如此多的异常情况要处理，这里可能要重新设计
    @Override
    @PostMapping
    default ResponseEntity create(DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, URISyntaxException {
        T result = getService().save(DTOToEntity(dto));
        String id = result.getClass().getDeclaredMethod("getId").invoke(result).toString();
        return ResponseEntity.created(new URI(getCurrentURI() + id))
                .headers(HeaderUtil.createEntityCreationAlert(result.getClass().getName(),id))
                .body(result);
    }

    @PutMapping
    default ResponseEntity update(DTO dto){
        T result = getService().save(DTOToEntity(dto));
        return ResponseEntity.ok().build();
    }

}

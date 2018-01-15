package cn.godbol.web.rest.impl;

import cn.godbol.message.ResponseMessage;
import cn.godbol.web.rest.api.SaveController;
import cn.godbol.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    default ResponseMessage create(@RequestBody DTO dto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        T result = getService().save(DTOToEntity(dto));
        return ResponseMessage.ok(result);
    }

}

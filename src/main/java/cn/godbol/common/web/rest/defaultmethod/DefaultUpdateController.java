package cn.godbol.common.web.rest.defaultmethod;

import cn.godbol.common.web.rest.api.UpdateController;
import cn.godbol.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-3-22.
 */
public interface DefaultUpdateController<T, ID extends Serializable, DTO> extends UpdateController<T, ID, DTO>{
    @Override
    @PutMapping
    default ResponseEntity update(@RequestBody DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        T result = getService().update(DTOToEntity(dto));
        String id = result.getClass().getMethod("getId").invoke(result).toString();
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(result.getClass().getName(), id))
                .body(entityToDTO(result));
    }
}

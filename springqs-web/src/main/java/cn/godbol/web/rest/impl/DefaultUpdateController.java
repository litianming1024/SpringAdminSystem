package cn.godbol.web.rest.impl;

import cn.godbol.message.ResponseMessage;
import cn.godbol.web.rest.api.UpdateController;
import cn.godbol.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-3-22.
 */
public interface DefaultUpdateController<T, ID extends Serializable, DTO> extends UpdateController<T, ID, DTO>{
    @Override
    @PutMapping(path = "/{id}")
    default ResponseMessage update(@PathVariable ID id, @RequestBody DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        T result = getService().update(DTOToEntity(dto));
//        String id = result.getClass().getMethod("getId").invoke(result).toString();
        return ResponseMessage.ok(entityToDTO(result));
    }
}

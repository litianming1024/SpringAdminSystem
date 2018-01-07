package cn.godbol.web.rest.api;

import cn.godbol.message.ResponseMessage;
import cn.godbol.service.api.UpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-3-22.
 */
public interface UpdateController<T, ID extends Serializable,DTO> {

    UpdateService<T, ID> getService();

    @PutMapping
    ResponseMessage update(@PathVariable ID id, @RequestBody DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);

    String getCurrentURI();
}

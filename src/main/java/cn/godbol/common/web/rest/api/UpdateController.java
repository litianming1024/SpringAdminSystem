package cn.godbol.common.web.rest.api;

import cn.godbol.common.service.api.UpdateService;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity update(@RequestBody DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);

    String getCurrentURI();
}

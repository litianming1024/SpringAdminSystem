package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.SaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable,DTO> {
    SaveService<T, ID> getService();

    @PostMapping
    ResponseEntity create(DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, URISyntaxException, NoSuchFieldException;

    @PutMapping
    ResponseEntity update(DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);

    String getCurrentURI();
}

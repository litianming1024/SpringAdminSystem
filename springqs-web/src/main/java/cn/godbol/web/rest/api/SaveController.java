package cn.godbol.web.rest.api;

import cn.godbol.service.api.SaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    ResponseEntity create(@RequestBody DTO dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, URISyntaxException;

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);

    String getCurrentURI();
}

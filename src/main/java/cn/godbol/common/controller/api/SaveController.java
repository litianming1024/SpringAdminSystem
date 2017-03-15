package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.SaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable,DTO> {
    SaveService<T, ID> getService();

    @PostMapping
    ResponseEntity create(DTO dto);

    @PutMapping
    ResponseEntity update(DTO dto);

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);
}

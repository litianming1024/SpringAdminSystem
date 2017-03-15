package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.SaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.Serializable;

/**
 * Created by li on 17-3-14.
 */
public interface DefaultSaveController<T, ID extends Serializable, DTO> extends SaveController<T, ID, DTO> {
    SaveService<T, ID> getService();

    @Override
    @PostMapping
    default ResponseEntity create(DTO dto){
        T result = getService().save(DTOToEntity(dto));
        return ResponseEntity.ok(result);
    }

    @PutMapping
    default ResponseEntity update(DTO dto){
        return ResponseEntity.ok().build();
    }

}

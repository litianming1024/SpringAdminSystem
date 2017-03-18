package cn.godbol.common.web.controller.api;

import cn.godbol.common.service.api.DeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
public interface DeleteController<T,ID extends Serializable> {
    DeleteService<T, ID> getService();

    @DeleteMapping(path = "/{id}")
    ResponseEntity delete(@PathVariable ID id);
}

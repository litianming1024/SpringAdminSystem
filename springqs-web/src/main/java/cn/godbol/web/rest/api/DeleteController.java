package cn.godbol.web.rest.api;

import cn.godbol.message.ResponseMessage;
import cn.godbol.service.api.DeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
public interface DeleteController<T,ID extends Serializable> {
    DeleteService<T, ID> getService();

    @DeleteMapping(path = "/{id}")
    ResponseMessage delete(@PathVariable ID id);
}

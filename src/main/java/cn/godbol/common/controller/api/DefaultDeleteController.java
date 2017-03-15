package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.DeleteService;
import cn.godbol.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.Serializable;

/**
 * Created by li on 17-3-13.
 */
public interface DefaultDeleteController<T, ID extends Serializable> extends DeleteController<T,ID> {

    DeleteService<T, ID> getService();

    @Override
    @DeleteMapping(path = "/{id}")
    default ResponseEntity delete(ID id){
        getService().delete(id);
        return ResponseEntity.ok().build();
    }
}

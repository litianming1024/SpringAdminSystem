package cn.godbol.common.controller.api;

import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.FindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
public interface FindController<T, ID extends Serializable, Q extends Serializable> {

    FindService<T, ID> getService();

    @GetMapping
    ResponseEntity findAll(Q param);

//    @GetMapping(path = "/{id}")
//    ResponseMessage findOne(@PathVariable ID id);

}

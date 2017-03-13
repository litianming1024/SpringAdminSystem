package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseEntityBuilder;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.FindService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultFindController<T, ID extends Serializable, Q extends Serializable> extends FindController<T, ID, Q>{
    FindService<T, ID> getService();

    @Override
    @GetMapping
    default ResponseEntity findAll(Q param){
        if (param instanceof QueryParam){
            QueryParam queryParam = (QueryParam)param;
            return ResponseEntity.ok(getService().findAll(queryParam.toPageRequest()));
        }else {
            return null;
        }
    }
//
//    @GetMapping(path = "/{id}")
//    ResponseMessage findOne(@PathVariable ID id);
}

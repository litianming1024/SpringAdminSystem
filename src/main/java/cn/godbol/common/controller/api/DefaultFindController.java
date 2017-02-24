package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseEntityBuilder;
import cn.godbol.common.message.ResponseMessage;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.FindService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultFindController<T, ID extends Serializable> extends FindController<T, ID>{
    FindService<T, ID> getService();

    default ResponseEntity findAll(QueryParam param){
        return ResponseEntityBuilder.find(getService().findAll(param.toPageRequest()));
    }
//
//    @GetMapping(path = "/{id}")
//    ResponseMessage findOne(@PathVariable ID id);
}

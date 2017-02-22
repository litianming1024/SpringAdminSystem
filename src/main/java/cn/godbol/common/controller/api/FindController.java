package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseMessage;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.FindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
public interface FindController<T, ID extends Serializable> {

    <S extends FindService<T, ID>> S getService();

    @GetMapping
    default ResponseMessage list(QueryParam param){
        return ResponseMessage.ok(getService().selectPage(param));
    }

    @GetMapping(path = "/{id}")
    default ResponseMessage getBy(@PathVariable ID id){
        //TODO

    }
}

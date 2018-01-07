package cn.godbol.web.rest.impl;

import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.web.rest.api.FindController;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultFindController<T, ID extends Serializable, Q extends Serializable, DTO> extends FindController<T, ID, Q, DTO> {

    @Override
    @GetMapping
    default ResponseMessage findAll(Q param){
        if (param instanceof QueryParam){
            QueryParam queryParam = (QueryParam)param;
//            return getService().findAll(queryParam.toPageRequest());
            return ResponseMessage.ok(getService().findAll(queryParam.toPageRequest()).map(entity->entityToDTO(entity)));
        }else {
            //TODO 这里要抛QueryException
            return null;
        }
    }
//
    @Override
    @GetMapping(path = "/{id}")
    default ResponseMessage findOne(@PathVariable ID id){
        return ResponseMessage.ok(entityToDTO(getService().findOne(id).orElseThrow(null)));
    }


}

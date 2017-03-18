package cn.godbol.common.web.rest.api;

import cn.godbol.common.query.QueryParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultFindController<T, ID extends Serializable, Q extends Serializable, DTO> extends FindController<T, ID, Q, DTO>{

    @Override
    @GetMapping
    default ResponseEntity findAll(Q param){
        if (param instanceof QueryParam){
            QueryParam queryParam = (QueryParam)param;
//            return getService().findAll(queryParam.toPageRequest());
            return ResponseEntity.ok(getService().findAll(queryParam.toPageRequest()).map(entity->entityToDTO(entity)));
        }else {
            //TODO 这里要抛QueryException
            return null;
        }
    }
//
    @Override
    @GetMapping(path = "/{id}")
    default ResponseEntity findOne(@PathVariable ID id){
        return ResponseEntity.ok(entityToDTO(getService().findOne(id)));
    }


}

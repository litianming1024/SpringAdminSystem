package cn.godbol.common.controller.api;

import cn.godbol.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by li on 17-3-13.
 */
public interface DefaultDeleteController<T, ID extends Serializable> extends DeleteController<T,ID> {

    @Override
    @DeleteMapping(path = "/{id}")
    default ResponseEntity delete(ID id){
        // TODO 方案待定
        //这里可能会产生异常，几乎使用了黑魔法
        Class<T> entityClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        getService().delete(id);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityDeletionAlert(entityClass.getName().toString(), id.toString())).build();
    }
}

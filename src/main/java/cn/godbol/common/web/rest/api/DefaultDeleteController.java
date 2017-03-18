package cn.godbol.common.web.rest.api;

import cn.godbol.web.rest.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Created by li on 17-3-13.
 */
public interface DefaultDeleteController<T, ID extends Serializable> extends DeleteController<T,ID> {

    @Override
    @DeleteMapping(path = "/{id}")
    default ResponseEntity delete(@PathVariable ID id){
        // TODO 方案待定
        //这里可能会产生异常，几乎使用了黑魔法
//        Class<T> entityClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        getService().delete(id);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityDeletionAlert("",id.toString())).build();
    }
}

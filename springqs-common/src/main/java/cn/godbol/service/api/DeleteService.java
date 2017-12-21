package cn.godbol.service.api;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DeleteService<T, ID extends Serializable> {
    void delete(ID id);
    void delete(Iterable<? extends T> entities);
    void delete(T entity);
}

package cn.godbol.common.service.api;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface SaveService<T, ID extends Serializable> {
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> save(Iterable<S> entities);

    String getEntityName();
}

package cn.godbol.service.api;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-3-22.
 */
public interface UpdateService<T, ID extends Serializable> {
    <S extends T> S update(S entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    <S extends T> Iterable<S> update(Iterable<S> entities);
}

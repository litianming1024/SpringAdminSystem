package cn.godbol.service.api;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-2-22.
 */
public interface SaveService<T, ID extends Serializable> {
    <S extends T> S save(S entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    <S extends T> Iterable<S> save(Iterable<S> entities);

}

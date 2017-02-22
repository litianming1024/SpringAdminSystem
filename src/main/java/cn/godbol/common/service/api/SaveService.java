package cn.godbol.common.service.api;

/**
 * Created by li on 17-2-22.
 */
public interface SaveService<T> {
    <S extends T> S save(S entity);
    //<S extends T> Iterable<S>
    <S extends T> Iterable<S> save(Iterable<S> entities);
}

package cn.godbol.common.service.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultSaveService<T, ID extends Serializable> extends SaveService<T, ID> {
    PagingAndSortingRepository<T,ID> getRepository();

    @Override
    default <S extends T> S save(S entity){
        return getRepository().save(entity);
    }

    @Override
    default <S extends T> Iterable<S> save(Iterable<S> entities){
        return getRepository().save(entities);
    }
}

package cn.godbol.common.service.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultDeleteService<T, ID extends Serializable> extends DeleteService<T,ID>{
    PagingAndSortingRepository<T, ID> getRepository();

    @Override
    default void delete(ID id){
        getRepository().delete(id);
    }

    @Override
    default void delete(Iterable<? extends T> entities){
        getRepository().delete(entities);
    }

    @Override
    default void delete(T entity){
        getRepository().delete(entity);
    }
}

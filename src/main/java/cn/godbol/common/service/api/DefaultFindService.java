package cn.godbol.common.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
public interface DefaultFindService<T, ID extends Serializable> extends FindService<T ,ID> {

    PagingAndSortingRepository<T, ID> getRepository();

    @Override
    default Page<T> findAll(Pageable pageable){
        return getRepository().findAll(pageable);
    }

    @Override
    default T findOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    default boolean exists(ID id){
        return getRepository().exists(id);
    }

    @Override
    default Iterable<T> findAll(){
        return getRepository().findAll();
    }

    @Override
    default  Iterable<T> findAll(Iterable<ID> ids){
        return getRepository().findAll(ids);
    }

    @Override
    default Long count(){
        return getRepository().count();
    }
}

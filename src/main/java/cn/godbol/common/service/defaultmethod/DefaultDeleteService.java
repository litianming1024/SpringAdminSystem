package cn.godbol.common.service.defaultmethod;

import cn.godbol.common.service.api.DeleteService;
import cn.godbol.common.service.exception.EntityNotFoundException;
import cn.godbol.common.service.exception.ServerAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultDeleteService<T, ID extends Serializable> extends DeleteService<T,ID> {
    JpaRepository<T, ID> getRepository();

    @Override
    default void delete(ID id){
        if (getRepository().exists(id)){
            getRepository().delete(id);
        } else {
            throw new EntityNotFoundException(this.getClass().getName(), ServerAction.DELETE, getEntityName(), id.toString());
        }

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

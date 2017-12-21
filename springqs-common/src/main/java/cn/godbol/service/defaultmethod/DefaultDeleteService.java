package cn.godbol.service.defaultmethod;

import cn.godbol.service.api.DeleteService;
import cn.godbol.service.exception.EntityNotFoundException;
import cn.godbol.service.exception.ServerAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultDeleteService<T, ID extends Serializable> extends DeleteService<T,ID> {
    JpaRepository<T, ID> getRepository();
    String getEntityName();

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

package cn.godbol.common.service.defaultmethod;

import cn.godbol.common.service.api.SaveService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultSaveService<T, ID extends Serializable> extends SaveService<T, ID> {
    JpaRepository<T,ID> getRepository();

    @Override
    default <S extends T> S save(S entity){
        return getRepository().save(entity);
    }

    @Override
    default <S extends T> Iterable<S> save(Iterable<S> entities){
        return getRepository().save(entities);
    }
}

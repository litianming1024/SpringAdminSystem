package cn.godbol.service.defaultmethod;

import cn.godbol.service.api.UpdateService;
import cn.godbol.service.exception.EntityNotFoundException;
import cn.godbol.service.exception.ServerAction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-3-22.
 */
public interface DefaultUpdateService<T, ID extends Serializable> extends UpdateService<T, ID> {

    JpaRepository<T, ID> getRepository();
    String getEntityName();

    @Override
    default <S extends T> S update(S entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<S> example = Example.of(entity, exampleMatcher);
        if (!getRepository().exists(example)){
            String id = entity.getClass().getMethod("getId").invoke(entity).toString();
            throw new EntityNotFoundException(this.getClass().getName(), ServerAction.UPDATE, getEntityName(), id);
        }
        return getRepository().save(entity);
    }

    @Override
    default <S extends T> Iterable<S> update(Iterable<S> entities){
        return getRepository().save(entities);
    }
}

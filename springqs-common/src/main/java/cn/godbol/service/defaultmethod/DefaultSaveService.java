package cn.godbol.service.defaultmethod;

import cn.godbol.service.api.SaveService;
import cn.godbol.service.exception.EntityExistsException;
import cn.godbol.service.exception.ServerAction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultSaveService<T, ID extends Serializable> extends SaveService<T, ID> {
    JpaRepository<T,ID> getRepository();
    String getEntityName();

    @Override
    default <S extends T> S save(S entity) {
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());
//        Example<S> example = Example.of(entity, exampleMatcher);
//        if (getRepository().exists(example)){
//            String id = null;
//            try {
//                id = entity.getClass().getMethod("getId").invoke(entity).toString();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//            throw new EntityExistsException(this.getClass().getName(), ServerAction.CREATE, getEntityName(), id);
//        }

        return getRepository().save(entity);
    }

    @Override
    default <S extends T> Iterable<S> save(Iterable<S> entities){
        return getRepository().save(entities);
    }
}

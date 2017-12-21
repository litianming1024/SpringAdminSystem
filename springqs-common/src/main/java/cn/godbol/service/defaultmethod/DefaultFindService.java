package cn.godbol.service.defaultmethod;

import cn.godbol.service.api.FindService;
import cn.godbol.service.exception.EntityNotFoundException;
import cn.godbol.service.exception.ServerAction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by li on 17-2-21.
 */
public interface DefaultFindService<T, ID extends Serializable> extends FindService<T ,ID> {

    JpaRepository<T, ID> getRepository();
    String getEntityName();

    @Override
    default Page<T> findAll(Pageable pageable){
        return getRepository().findAll(pageable);
    }

    @Override
    default Optional<T> findOne(ID id) {

        Optional<T> result = Optional.ofNullable(getRepository().findOne(id));
        if (!result.isPresent()){
            throw new EntityNotFoundException(this.getClass().getName(), ServerAction.GET, getEntityName(), id.toString());
        }
        return result;
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

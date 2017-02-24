package cn.godbol.common.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;


/**
 * Created by li on 17-2-20.
 */
public interface FindService<T, ID extends Serializable> {

    Page<T> findAll(Pageable pageable);

    T findOne(ID id);

    boolean exists(ID id);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);

    Long count();
}

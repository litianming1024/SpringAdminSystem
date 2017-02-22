package cn.godbol.common.service.api;

import cn.godbol.common.entity.PageResult;
import cn.godbol.common.query.QueryParam;

import java.io.Serializable;


/**
 * Created by li on 17-2-20.
 */
public interface FindService<T, ID extends Serializable> {
    /**
     * 分页查询
     * @param param 参数
     * @return 分页查询结果
     */
    PageResult<T> selectPage(QueryParam param);

    T findOne(ID id);

    boolean exists(ID id);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);
}

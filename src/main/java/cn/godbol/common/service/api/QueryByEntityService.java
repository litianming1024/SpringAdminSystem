package cn.godbol.common.service.api;

import cn.godbol.common.entity.PageResult;
import cn.godbol.common.query.QueryParam;

import java.io.Serializable;


/**
 * Created by li on 17-2-20.
 */
public interface QueryByEntityService<E, ID> {
    /**
     * 分页查询
     * @param param 参数
     * @return 分页查询结果
     */
    PageResult<E> selectPage(QueryParam param);

    E findOne(ID id);
}

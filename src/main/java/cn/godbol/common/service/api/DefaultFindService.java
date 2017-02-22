package cn.godbol.common.service.api;

import cn.godbol.common.entity.PageResult;
import cn.godbol.common.query.QueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
public interface DefaultFindService<T, ID extends Serializable> extends FindService<T ,ID> {
    PagingAndSortingRepository<T, ID> getRepository();
    /**
     * 分页进行查询数据
     *
     * @param param 查询参数
     * @return 分页查询结果
     */
    @Override
    default PageResult<T> selectPage(QueryParam param) {
        PageResult<T> pagerResult = new PageResult<>();
        // page start from 0, but my BaseDataTable start from 1
        Pageable pageable = new PageRequest(param.getCurrentPage() - 1, param.getPageSize(), param.getSort());
        Page<T> page = getRepository().findAll(pageable);
        pagerResult.setTotal(page.getTotalElements());
        System.out.println(page);
        pagerResult.setData(page.getContent());
        return pagerResult;
    }

    @Override
    default T findOne(ID id) {
        return getRepository().findOne(id);
    }
}

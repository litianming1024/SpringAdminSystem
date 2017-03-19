package cn.godbol.common.service.defaultmethod;

import cn.godbol.common.service.api.CrudService;
import cn.godbol.common.service.defaultmethod.DefaultDeleteService;
import cn.godbol.common.service.defaultmethod.DefaultFindService;
import cn.godbol.common.service.defaultmethod.DefaultSaveService;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultCrudService<T, ID extends Serializable> extends
        CrudService<T, ID>,
        DefaultSaveService<T, ID>,
        DefaultDeleteService<T, ID>,
        DefaultFindService<T, ID> {
}

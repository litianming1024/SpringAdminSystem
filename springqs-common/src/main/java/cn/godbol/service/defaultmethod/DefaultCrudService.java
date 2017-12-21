package cn.godbol.service.defaultmethod;


import cn.godbol.service.api.CrudService;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultCrudService<T, ID extends Serializable> extends
        CrudService<T, ID>,
        DefaultSaveService<T, ID>,
        DefaultDeleteService<T, ID>,
        DefaultFindService<T, ID>,
        DefaultUpdateService<T, ID> {
}

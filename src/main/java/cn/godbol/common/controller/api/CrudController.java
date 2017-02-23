package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.DeleteService;
import cn.godbol.common.service.api.FindService;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface CrudController<T, ID extends Serializable> extends
        SaveController<T, ID>,
        DeleteService<T, ID>,
        FindService<T, ID>{
}

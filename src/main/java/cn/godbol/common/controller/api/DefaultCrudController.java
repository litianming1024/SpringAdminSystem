package cn.godbol.common.controller.api;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultCrudController<T, ID extends Serializable, Q extends Serializable, DTO> extends
        CrudController<T, ID, Q, DTO>,
        DefaultSaveController<T, ID, DTO>,
        DefaultDeleteController<T, ID>,
        DefaultFindController<T, ID, Q, DTO>{
}

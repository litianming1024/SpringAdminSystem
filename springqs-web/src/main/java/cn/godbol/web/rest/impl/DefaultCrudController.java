package cn.godbol.web.rest.impl;

import cn.godbol.web.rest.api.CrudController;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultCrudController<T, ID extends Serializable, Q extends Serializable, DTO> extends
        CrudController<T, ID, Q, DTO>,
        DefaultSaveController<T, ID, DTO>,
        DefaultDeleteController<T, ID>,
        DefaultFindController<T, ID, Q, DTO>,
        DefaultUpdateController<T, ID, DTO> {
}

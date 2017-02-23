package cn.godbol.common.controller.api;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface DefaultCrudController<T, ID extends Serializable> extends CrudController<T, ID> {
}

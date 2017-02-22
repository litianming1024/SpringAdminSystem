package cn.godbol.common.service.api;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface CrudService<T, ID extends Serializable> extends
        SaveService<T>,
        DeleteService<T, ID>,
        FindService<T, ID> {
}

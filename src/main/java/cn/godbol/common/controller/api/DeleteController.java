package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.DeleteService;

import java.io.Serializable;

/**
 * Created by li on 17-2-21.
 */
public interface DeleteController<T,ID extends Serializable> {
    <S extends DeleteService<T, ID>> S getService();

}

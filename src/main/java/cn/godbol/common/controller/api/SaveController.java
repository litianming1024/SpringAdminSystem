package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.SaveService;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable> {
    <S extends SaveService<T, ID>> S getService();
}

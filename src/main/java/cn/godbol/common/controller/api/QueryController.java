package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseMessage;
import cn.godbol.common.service.api.QueryByEntityService;

import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
public interface QueryController<E, Q extends Serializable> {

    <T extends QueryByEntityService<E>> T getService();

    default ResponseMessage list(Q param){
        return ResponseMessage.ok(getService().selectPage(param));
    }
}

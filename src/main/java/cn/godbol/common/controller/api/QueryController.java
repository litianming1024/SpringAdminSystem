package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseMessage;
import cn.godbol.common.query.QueryParam;
import cn.godbol.common.service.api.QueryByEntityService;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
public interface QueryController<E> {

    <T extends QueryByEntityService<E>> T getService();

    @GetMapping
    default ResponseMessage list(QueryParam param){
        return ResponseMessage.ok(getService().selectPage(param));
    }
}

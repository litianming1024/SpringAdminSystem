package cn.godbol.common.controller.api;

import cn.godbol.common.message.ResponseMessage;
import cn.godbol.common.service.api.SaveService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable> {
    <S extends SaveService<T, ID>> S getService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseMessage add(@RequestBody T data);
}

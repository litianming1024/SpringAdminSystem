package cn.godbol.common.controller.api;

import cn.godbol.common.service.api.SaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable> {
    SaveService<T, ID> getService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity create(@RequestBody T data);
}

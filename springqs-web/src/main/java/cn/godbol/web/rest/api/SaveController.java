package cn.godbol.web.rest.api;

import cn.godbol.message.ResponseMessage;
import cn.godbol.service.api.SaveService;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * Created by li on 17-2-22.
 */
public interface SaveController<T, ID extends Serializable,DTO> {
    SaveService<T, ID> getService();

    @PostMapping
    ResponseMessage create(@RequestBody DTO dto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, WxErrorException;

    T DTOToEntity(DTO dto);

    DTO entityToDTO(T entity);

}

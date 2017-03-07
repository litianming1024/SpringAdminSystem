package cn.godbol.common.support;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by li on 17-3-7.
 */
@ControllerAdvice(annotations = {RestController.class})
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    //TODO all exceptions for restcontroller need handle in this
}

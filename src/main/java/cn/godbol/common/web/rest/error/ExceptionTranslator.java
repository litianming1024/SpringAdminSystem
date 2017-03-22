package cn.godbol.common.web.rest.error;

import cn.godbol.common.service.exception.EntityExistsException;
import cn.godbol.common.service.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by li on 17-3-18.
 * TODO 未来要重新设计
 * 异常在这里转换成ResponseEntity,由于Spring Data的原因delete的异常无法封装，要捕获EmptyResultDataAccessException
 * 如果要达到类似Spring Data的效果，要找到对应的异常，可以先find再delete，考虑到以后要使用MyBatis,对删除异常的处理使用默认
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionTranslator{

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorVM entityNotFound(EntityNotFoundException ex, final HttpServletRequest request) {
        return new ErrorVM(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                "",
                ex.getClass().getName(),
                ex.toString(),
                request.getRequestURI(),
                null);
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorVM entityExists(EntityExistsException ex, final HttpServletRequest request){
        return new ErrorVM(System.currentTimeMillis(),
                HttpStatus.CONFLICT.value(),
                "",
                ex.getClass().getName(),
                ex.toString(),
                request.getRequestURI(),
                null);
    }
}

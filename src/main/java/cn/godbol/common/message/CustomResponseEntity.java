package cn.godbol.common.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * Created by li on 17-2-25.
 */
public class CustomResponseEntity<T> extends ResponseEntity<T> {


    /**
     * Create a new {@code ResponseEntity} with the given status code, and no body nor headers.
     *
     * @param status the status code
     */
    public CustomResponseEntity(HttpStatus status) {
        super(status);
    }

    /**
     * Create a new {@code ResponseEntity} with the given body and status code, and no headers.
     *
     * @param body   the entity body
     * @param status the status code
     */
    public CustomResponseEntity(T body, HttpStatus status) {
        super(body, status);
    }

    /**
     * Create a new {@code HttpEntity} with the given headers and status code, and no body.
     *
     * @param headers the entity headers
     * @param status  the status code
     */
    public CustomResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    /**
     * Create a new {@code HttpEntity} with the given body, headers, and status code.
     *
     * @param body    the entity body
     * @param headers the entity headers
     * @param status  the status code
     */
    public CustomResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

//    public CustomResponseEntity exclude(Collection<String> fields){
//        Map<Class<?>, Set<String>> excludes = new HashMap<>();
//
//        if (getBody() instanceof Map){
//            Map<String, Object> body =(Map<String, Object>) getBody();
//        }
//        return new CustomResponseEntity<>(body,getStatusCode());
//    }

//    public CustomResponseEntity exclude(String... fields) {
//        return exclude(Arrays.asList(fields));
//    }
}

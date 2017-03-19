package cn.godbol.common.web.rest.error;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by li on 17-3-19.
 */
@Getter
public class ErrorVM implements Serializable {
    private final long timestamp;
    private final int status;
    private final String error;
    private final String exception;
    private final String message;
    private final String path;
    private List<FieldErrorVM> fieldErrors;

    public ErrorVM(long timestamp, int status, String error, String exception, String message, String path, List<FieldErrorVM> fieldErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }


    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldErrorVM(objectName, field, message));
    }
}

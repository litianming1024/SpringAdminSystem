package cn.godbol.common.web.rest.error;

import java.io.Serializable;

/**
 * Created by li on 17-3-19.
 */
public class FieldErrorVM implements Serializable {

    private final String objectName;

    private final String field;

    private final String message;

    public FieldErrorVM(String dto, String field, String message) {
        this.objectName = dto;
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}

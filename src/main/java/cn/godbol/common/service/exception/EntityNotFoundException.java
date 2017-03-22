package cn.godbol.common.service.exception;

import lombok.Getter;

/**
 * Created by li on 17-3-18.
 */
@Getter
public class EntityNotFoundException extends ServiceException {

    private final String entityName;
    private final String id;

    public EntityNotFoundException(String serviceName, ServerAction serverAction, String entityName, String id) {
        super(serviceName, serverAction);
        this.entityName = entityName;
        this.id = id;
    }

}

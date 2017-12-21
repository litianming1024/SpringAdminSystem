package cn.godbol.service.exception;

/**
 * Created by li on 17-3-22.
 */
public class EntityExistsException extends ServiceException {
    private final String entityName;
    private final String id;

    public EntityExistsException(String serviceName, ServerAction serverAction, String entityName, String id) {
        super(serviceName, serverAction);
        this.entityName = entityName;
        this.id = id;
    }
}

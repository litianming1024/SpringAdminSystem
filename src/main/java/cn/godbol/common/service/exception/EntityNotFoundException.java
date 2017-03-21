package cn.godbol.common.service.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by li on 17-3-18.
 */
@Getter
public class EntityNotFoundException extends ServiceException {

    private final String entityName;
    private final String id;

    public EntityNotFoundException(String serviceName, ServerErrorConstant serverErrorConstant, String entityName, String id) {
        super(serviceName, serverErrorConstant);
        this.entityName = entityName;
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + "EntityNotFoundException{" +
                "entityName='" + entityName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

package cn.godbol.common.service.exception;

import lombok.Getter;

/**
 * Created by li on 17-3-18.
 */
@Getter
public class ServiceException extends RuntimeException {
    private final String serviceName;
    private final ServerErrorConstant serverErrorConstant;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ServiceException(String serviceName, ServerErrorConstant serverErrorConstant) {
        super("service.error");
        this.serviceName = serviceName;
        this.serverErrorConstant = serverErrorConstant;
    }
}

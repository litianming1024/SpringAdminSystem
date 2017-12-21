package cn.godbol.service.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by li on 17-3-18.
 */
@Getter @ToString
public class ServiceException extends RuntimeException {
    private final String serviceName;
    private final ServerAction serverAction;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ServiceException(String serviceName, ServerAction serverAction) {
        super("service.error");
        this.serviceName = serviceName;
        this.serverAction = serverAction;
    }
}

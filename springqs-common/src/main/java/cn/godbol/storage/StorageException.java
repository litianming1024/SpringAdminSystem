package cn.godbol.storage;

/**
 * Created by li on 2017-11-23 下午9:42.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

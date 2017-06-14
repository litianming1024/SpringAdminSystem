package cn.godbol.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by li on 17-6-14.
 */
@Slf4j
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
    @Override
    public Class<?> getSecureObjectClass() {
        return null;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return null;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

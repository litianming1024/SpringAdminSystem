package cn.godbol.jwt.util;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by li on 2017-12-22 下午1:28.
 */
@Component
public class TimeProvider implements Serializable{
    public Date now() {
        return new Date();
    }
}

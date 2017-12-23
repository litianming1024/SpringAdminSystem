package cn.godbol.jwt.controller.rest.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by li on 2017-12-22 下午2:24.
 */
@Getter@Setter
public class JwtAuthenticationRequest implements Serializable {
    private String username;
    private String password;
}

package cn.godbol.jwt.controller.rest.common;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by li on 2017-12-22 下午2:23.
 */
@Getter
public class JwtAuthenticationResponse implements Serializable {

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}

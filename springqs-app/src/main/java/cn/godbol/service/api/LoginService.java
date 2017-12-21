package cn.godbol.service.api;

import org.springframework.http.ResponseEntity;

/**
 * Created by li on 2017-12-15 下午12:15.
 */
public interface LoginService {
    public ResponseEntity login(String userName, String password);
}

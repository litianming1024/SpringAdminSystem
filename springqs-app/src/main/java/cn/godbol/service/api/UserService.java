package cn.godbol.service.api;

import cn.godbol.jwt.domain.User;

/**
 * Created by li on 2017-12-15 下午2:13.
 */
public interface UserService {
    User getByUsername(String username);
}

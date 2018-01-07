package cn.godbol.jwt.repository.api;

import cn.godbol.domain.User;

/**
 * Created by Li on 2016/10/15.
 */
public interface UserRepositoryApi {
    User getByUsername(String username);

}

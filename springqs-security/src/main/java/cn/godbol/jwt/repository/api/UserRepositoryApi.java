package cn.godbol.jwt.repository.api;

import cn.godbol.jwt.domain.api.UserApi;

/**
 * Created by Li on 2016/10/15.
 */
public interface UserRepositoryApi {
    UserApi getByUsername(String username);

}

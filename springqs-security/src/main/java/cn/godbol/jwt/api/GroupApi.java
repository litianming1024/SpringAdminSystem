package cn.godbol.jwt.api;

import java.util.Collection;

/**
 * Created by li on 2017-12-22 下午4:15.
 */
public interface GroupApi {
    Collection<? extends AuthorityApi> getAuthorities();
}

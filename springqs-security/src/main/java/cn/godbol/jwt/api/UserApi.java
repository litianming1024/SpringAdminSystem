package cn.godbol.jwt.api;

import cn.godbol.domain.Group;

import java.util.Collection;

/**
 * Created by li on 2017-12-22 下午1:11.
 */
public interface UserApi{
    String getUsername();

    boolean isAccountNonExpired();

    String getPassword();

    boolean isAccountNonLocked();

    boolean isEnabled();

    Collection<Group> getGroups();

    boolean isCredentialsNonExpired();
}

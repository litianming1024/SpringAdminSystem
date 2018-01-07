package cn.godbol.jwt.repository.api;


import cn.godbol.domain.Authority;
import cn.godbol.domain.api.AuthorityApi;

import java.util.List;

/**
 * Created by li on 2017-12-22 下午5:19.
 */
public interface AuthorityRepositoryApi {
    List<Authority> findAll();
}

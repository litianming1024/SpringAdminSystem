package cn.godbol.domain.repository.api;


import cn.godbol.domain.Authority;

import java.util.List;

/**
 * Created by li on 2017-12-22 下午5:19.
 */
public interface AuthorityRepositoryApi {
    List<Authority> findAll();
}

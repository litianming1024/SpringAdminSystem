package cn.godbol.domain.repository;

import cn.godbol.domain.Authority;
import cn.godbol.domain.repository.api.AuthorityRepositoryApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Li on 2016/11/18.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>, AuthorityRepositoryApi{
    List<Authority> findAll();
}

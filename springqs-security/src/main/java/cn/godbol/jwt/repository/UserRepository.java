package cn.godbol.jwt.repository;

import cn.godbol.jwt.domain.User;
import cn.godbol.jwt.domain.api.UserApi;
import cn.godbol.jwt.repository.api.UserRepositoryApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2017-12-22 下午4:33.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>/*, UserRepositoryApi*/ {
    User getByUsername(String username);
}

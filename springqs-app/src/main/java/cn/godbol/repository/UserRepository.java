package cn.godbol.repository;

import cn.godbol.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2017-12-22 下午4:33.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>/*, UserRepositoryApi*/ {
    User getByUsername(String username);
}

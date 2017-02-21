package cn.godbol.domain.repository;

import cn.godbol.domain.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Li on 2016/10/15.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User getByUsername(String username);
    User getById(Long id);
}

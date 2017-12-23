package cn.godbol.jwt.repository;

import cn.godbol.jwt.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Li on 2016/10/15.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}

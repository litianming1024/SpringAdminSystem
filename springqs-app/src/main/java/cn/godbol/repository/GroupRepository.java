package cn.godbol.repository;

import cn.godbol.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-14 下午6:07.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}

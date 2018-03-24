package cn.godbol.domain.repository;

import cn.godbol.domain.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:38.
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}

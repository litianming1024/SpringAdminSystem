package cn.godbol.repository;

import cn.godbol.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:38.
 */
@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}

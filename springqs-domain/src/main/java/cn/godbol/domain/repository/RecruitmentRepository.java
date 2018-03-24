package cn.godbol.domain.repository;

import cn.godbol.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:39.
 */
@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
}

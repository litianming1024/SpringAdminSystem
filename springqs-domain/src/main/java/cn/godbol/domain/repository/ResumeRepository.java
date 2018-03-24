package cn.godbol.domain.repository;

import cn.godbol.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:40.
 */
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findByUserId(Long id);
}

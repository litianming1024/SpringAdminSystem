package cn.godbol.domain.repository;

import cn.godbol.domain.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:34.
 */
@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long>{
    Page<Apply> findByApplyStatusIn(Collection status, Pageable pageable);
}

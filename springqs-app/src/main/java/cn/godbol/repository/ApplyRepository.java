package cn.godbol.repository;

import cn.godbol.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:34.
 */
@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long>{
}

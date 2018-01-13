package cn.godbol.repository;

import cn.godbol.domain.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:37.
 */
@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfo, Long>{
}

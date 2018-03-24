package cn.godbol.service.impl;

import cn.godbol.domain.Recruitment;
import cn.godbol.domain.repository.RecruitmentRepository;
import cn.godbol.service.api.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:53.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    RecruitmentRepository recruitmentRepository;

    @Override
    public JpaRepository<Recruitment, Long> getRepository() {
        return recruitmentRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}

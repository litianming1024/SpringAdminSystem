package cn.godbol.service.impl;

import cn.godbol.domain.Education;
import cn.godbol.repository.EducationRepository;
import cn.godbol.service.api.EducationService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:49.
 */
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public JpaRepository<Education, Long> getRepository() {
        return educationRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}

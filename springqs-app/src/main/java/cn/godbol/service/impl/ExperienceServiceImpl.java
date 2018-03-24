package cn.godbol.service.impl;

import cn.godbol.domain.Experience;
import cn.godbol.domain.repository.ExperienceRepository;
import cn.godbol.service.api.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-03-13 下午2:11.
 */
@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public JpaRepository<Experience, Long> getRepository() {
        return experienceRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}

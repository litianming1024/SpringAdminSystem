package cn.godbol.service.impl;

import cn.godbol.domain.Experience;
import cn.godbol.repository.ExperienceRepository;
import cn.godbol.service.api.ExperiendeService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:51.
 */
@Service
public class ExperiendeServiceImpl implements ExperiendeService, DefaultCrudService<Experience, Long> {
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

package cn.godbol.web.rest;

import cn.godbol.domain.Experience;
import cn.godbol.dto.ExperienceDTO;
import cn.godbol.mapper.ExperienceMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.ExperienceService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-03-13 下午2:08.
 */
@RestController
@RequestMapping(value = "/api/experience")
public class ExperienceController implements DefaultCrudController<Experience, Long, QueryParam, ExperienceDTO> {

    @Autowired
    ExperienceService experienceService;

    @Autowired
    ExperienceMapper experienceMapper;

    @Override
    public CrudService<Experience, Long> getService() {
        return experienceService;
    }

    @Override
    public Experience DTOToEntity(ExperienceDTO experienceDTO) {
        return experienceMapper.experienceDTOToExperience(experienceDTO);
    }

    @Override
    public ExperienceDTO entityToDTO(Experience experience) {
        return experienceMapper.experienceToExperienceDTO(experience);
    }
}

package cn.godbol.web.rest;

import cn.godbol.domain.Education;
import cn.godbol.domain.dto.EducationDTO;
import cn.godbol.domain.mapper.EducationMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.EducationService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-03-14 下午4:55.
 */
@RestController
@RequestMapping(value = "/api/education")
public class EducationController implements DefaultCrudController<Education, Long, QueryParam, EducationDTO>{

    @Autowired
    EducationService educationService;

    @Autowired
    EducationMapper educationMapper;

    @Override
    public CrudService<Education, Long> getService() {
        return educationService;
    }

    @Override
    public Education DTOToEntity(EducationDTO educationDTO) {
        return educationMapper.educationDTOToEducation(educationDTO);
    }

    @Override
    public EducationDTO entityToDTO(Education education) {
        return educationMapper.educationToEducationDTO(education);
    }
}

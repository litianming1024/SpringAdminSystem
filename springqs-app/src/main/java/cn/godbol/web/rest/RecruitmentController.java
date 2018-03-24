package cn.godbol.web.rest;

import cn.godbol.domain.Recruitment;

import cn.godbol.domain.dto.RecruitmentDTO;
import cn.godbol.domain.mapper.RecruitmentMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.RecruitmentService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-01-15 下午1:46.
 */
@RestController
@RequestMapping(value = "/api/recruitment")
public class RecruitmentController implements DefaultCrudController<Recruitment, Long, QueryParam, RecruitmentDTO> {

    @Autowired
    RecruitmentService recruitmentService;

    @Autowired
    RecruitmentMapper recruitmentMapper;

    @Override
    public CrudService<Recruitment, Long> getService() {
        return recruitmentService;
    }

    @Override
    public Recruitment DTOToEntity(RecruitmentDTO recruitmentDTO) {
        return recruitmentMapper.recruitmentDTOToRecruitment(recruitmentDTO);
    }

    @Override
    public RecruitmentDTO entityToDTO(Recruitment recruitment) {
        return recruitmentMapper.recruitmentToRecruitmentDTO(recruitment);
    }
}

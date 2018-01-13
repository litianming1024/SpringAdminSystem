package cn.godbol.web.rest;


import cn.godbol.domain.Resume;
import cn.godbol.dto.ResumeDTO;
import cn.godbol.mapper.ResumeMapper;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.ResumeService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-01-13 下午10:59.
 */
@RestController
@RequestMapping(value = "/api/resume")
public class ResumeController implements DefaultCrudController<Resume, Long, QueryParam, ResumeDTO> {

    @Autowired
    ResumeService resumeService;

    @Autowired
    ResumeMapper resumeMapper;

    @Override
    public CrudService<Resume, Long> getService() {
        return resumeService;
    }

    @Override
    public Resume DTOToEntity(ResumeDTO resumeDTO) {
        return resumeMapper.resumeDTOToResume(resumeDTO);
    }

    @Override
    public ResumeDTO entityToDTO(Resume resume) {
        return resumeMapper.resumeToResumeDTO(resume);
    }
}

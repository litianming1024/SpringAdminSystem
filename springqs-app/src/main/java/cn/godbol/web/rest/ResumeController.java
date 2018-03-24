package cn.godbol.web.rest;


import cn.godbol.domain.Resume;
import cn.godbol.domain.dto.ResumeDTO;
import cn.godbol.domain.mapper.ResumeMapper;
import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.CrudService;
import cn.godbol.service.api.ResumeService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li on 2018-01-13 下午10:59.
 * 简历
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

    //按照设计，一个人可以有多个简历，这里默认只有一个，其余根据情况再做变更
    @GetMapping(path = "/user/{id}")
    public ResponseMessage getResumeByUserId(@PathVariable Long id) {
        return ResponseMessage.ok(resumeMapper.resumeToResumeDTO(resumeService.findOrCreate(id)));
    }

}

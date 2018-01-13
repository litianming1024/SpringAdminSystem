package cn.godbol.service.impl;

import cn.godbol.domain.Resume;
import cn.godbol.repository.ResumeRepository;
import cn.godbol.service.api.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:56.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    @Override
    public JpaRepository<Resume, Long> getRepository() {
        return resumeRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}

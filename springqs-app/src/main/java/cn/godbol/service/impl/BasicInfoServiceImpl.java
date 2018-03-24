package cn.godbol.service.impl;

import cn.godbol.domain.BasicInfo;
import cn.godbol.domain.Resume;
import cn.godbol.domain.repository.BasicInfoRepository;
import cn.godbol.domain.repository.ResumeRepository;
import cn.godbol.service.api.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:47.
 */
@Service
public class BasicInfoServiceImpl implements BasicInfoService {
    @Autowired
    BasicInfoRepository basicInfoRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Override
    public JpaRepository<BasicInfo, Long> getRepository() {
        return basicInfoRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public BasicInfo createByResumeId(Long resumeId, BasicInfo basicInfo) {
        Resume resume = resumeRepository.getOne(resumeId);
        basicInfo.setResume(resume);
        basicInfo = basicInfoRepository.save(basicInfo);
        return basicInfo;
    }
}

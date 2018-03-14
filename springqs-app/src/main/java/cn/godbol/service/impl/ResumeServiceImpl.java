package cn.godbol.service.impl;

import cn.godbol.domain.BasicInfo;
import cn.godbol.domain.Group;
import cn.godbol.domain.Resume;
import cn.godbol.domain.User;
import cn.godbol.repository.ResumeRepository;
import cn.godbol.repository.UserRepository;
import cn.godbol.service.api.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * Created by li on 2018-01-13 下午10:56.
 */
@Service
//@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public JpaRepository<Resume, Long> getRepository() {
        return resumeRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public Resume findByUserId(Long id) {
        return resumeRepository.findByUserId(id);
    }

    @Override
    public Resume findOrCreate(Long id) {
        Resume resume = resumeRepository.findByUserId(id);
        if (resume == null) {
            User user = userRepository.findOne(id);
            resume = new Resume();
            resume.setUser(user);
            resumeRepository.save(resume);
        }
        return resume;
    }
}

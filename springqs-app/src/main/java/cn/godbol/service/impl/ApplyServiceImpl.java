package cn.godbol.service.impl;

import cn.godbol.domain.Apply;
import cn.godbol.repository.ApplyRepository;
import cn.godbol.service.api.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:41.
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyRepository applyRepository;

    @Override
    public JpaRepository<Apply, Long> getRepository() {
        return applyRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public Page<Apply> findByApplyStatusIn(Collection<Integer> status, Pageable pageable) {
        return applyRepository.findByApplyStatusIn(status, pageable);
    }
}

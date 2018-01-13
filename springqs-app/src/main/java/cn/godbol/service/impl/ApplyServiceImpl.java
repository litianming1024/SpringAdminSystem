package cn.godbol.service.impl;

import cn.godbol.domain.Apply;
import cn.godbol.repository.ApplyRepository;
import cn.godbol.service.api.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
}

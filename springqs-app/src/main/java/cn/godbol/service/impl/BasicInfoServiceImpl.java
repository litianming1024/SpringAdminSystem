package cn.godbol.service.impl;

import cn.godbol.domain.BasicInfo;
import cn.godbol.repository.BasicInfoRepository;
import cn.godbol.service.api.BasicInfoService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by li on 2018-01-13 下午10:47.
 */
public class BasicInfoServiceImpl implements BasicInfoService, DefaultCrudService<BasicInfo, Long> {
    @Autowired
    BasicInfoRepository basicInfoRepository;

    @Override
    public JpaRepository<BasicInfo, Long> getRepository() {
        return basicInfoRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }
}

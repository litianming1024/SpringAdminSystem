package cn.godbol.service.api;

import cn.godbol.domain.BasicInfo;
import cn.godbol.service.defaultmethod.DefaultCrudService;

/**
 * Created by li on 2018-01-13 下午10:46.
 */
public interface BasicInfoService extends DefaultCrudService<BasicInfo, Long> {
    BasicInfo createByResumeId(Long resumeId, BasicInfo basicInfo);
}

package cn.godbol.service.api;

import cn.godbol.domain.Resume;
import cn.godbol.service.defaultmethod.DefaultCrudService;

/**
 * Created by li on 2018-01-13 下午10:55.
 */
public interface ResumeService extends DefaultCrudService<Resume, Long> {

    Resume findByUserId(Long id);

    Resume findOrCreate(Long id);
}

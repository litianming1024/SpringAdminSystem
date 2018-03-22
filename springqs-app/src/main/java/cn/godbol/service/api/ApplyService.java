package cn.godbol.service.api;

import cn.godbol.domain.Apply;
import cn.godbol.domain.Appointment;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:42.
 */
public interface ApplyService extends DefaultCrudService<Apply, Long> {
    Page<Apply> findByApplyStatusIn(Collection<Integer> applyStatus, Pageable pageable);
}

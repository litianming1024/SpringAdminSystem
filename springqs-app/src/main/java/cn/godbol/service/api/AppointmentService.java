package cn.godbol.service.api;

import cn.godbol.domain.Appointment;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:44.
 */
public interface AppointmentService extends DefaultCrudService<Appointment, Long> {
    Page<Appointment> findAppointmentByApplyStatus(Collection<Integer> applyStatus, Pageable pageable);
    Appointment findLatest(Long id);

    Appointment findByApplyIdAndInterviewType(Long applyId, Integer interviewType);
    Page<Appointment> findAppointmentsByInterviewTypeAndStatus(int interviewType, int status, Pageable pageable);

    Page<Appointment> findAppointmentsByStatus(Collection<Integer> status, Pageable pageable);

    long countAllByStatus(Integer status);
    long countAllByStatus(Collection<Integer> status);
}

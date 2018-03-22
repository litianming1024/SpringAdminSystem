package cn.godbol.service.impl;

import cn.godbol.domain.Appointment;
import cn.godbol.repository.AppointmentRepository;
import cn.godbol.service.api.AppointmentService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:44.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public JpaRepository<Appointment, Long> getRepository() {
        return appointmentRepository;
    }

    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public Page<Appointment> findAppointmentByApplyStatus(Collection<Integer> applyStatus, Pageable pageable) {
        return appointmentRepository.findAppointmentByApplyStatus(applyStatus, pageable);
    }

    @Override
    public Appointment findLatest(Long id) {
        return appointmentRepository.findByApplyIdOrderByApplyDesc(id);
    }
}

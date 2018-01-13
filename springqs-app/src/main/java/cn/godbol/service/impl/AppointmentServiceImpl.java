package cn.godbol.service.impl;

import cn.godbol.domain.Appointment;
import cn.godbol.repository.AppointmentRepository;
import cn.godbol.service.api.AppointmentService;
import cn.godbol.service.defaultmethod.DefaultCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018-01-13 下午10:44.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService, DefaultCrudService<Appointment, Long> {
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
}

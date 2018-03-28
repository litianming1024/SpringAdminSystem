package cn.godbol.service.impl;

import cn.godbol.domain.Appointment;
import cn.godbol.domain.repository.AppointmentRepository;
import cn.godbol.service.api.AppointmentService;
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

    @Override
    public Appointment findByApplyIdAndInterviewType(Long applyId, Integer interviewType) {
        return appointmentRepository.findByApplyIdAndInterviewType(applyId, interviewType);
    }

    public Page<Appointment> findAppointmentsByInterviewTypeAndStatus(int interviewType, int status, Pageable pageable) {
        return appointmentRepository.findAppointmentsByInterviewTypeAndStatus(interviewType, status, pageable);
    }

    @Override
    public Page<Appointment> findAppointmentsByStatus(Collection<Integer> status, Pageable pageable) {
        return appointmentRepository.findAppointmentsByStatusIn(status, pageable);
    }

    @Override
    public long countAllByStatus(Integer status) {
        return appointmentRepository.countAllByStatus(status);
    }

    @Override
    public long countAllByStatus(Collection<Integer> status) {
        return appointmentRepository.countAllByStatus(status);
    }
}

package cn.godbol.domain.repository;

import cn.godbol.domain.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午10:35.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT ap FROM Appointment ap, Apply apply WHERE ap.apply = apply AND apply.applyStatus in :applyStatus")
    Page<Appointment> findAppointmentByApplyStatus(@Param("applyStatus") Collection<Integer> applyStatus, Pageable pageable);

    Appointment findByApplyIdOrderByApplyDesc(Long id);

    Appointment findByApplyIdAndInterviewType(Long applyId, Integer interviewType);

    Page<Appointment> findAppointmentsByInterviewTypeAndStatus(int interviewType, int status, Pageable pageable);
}

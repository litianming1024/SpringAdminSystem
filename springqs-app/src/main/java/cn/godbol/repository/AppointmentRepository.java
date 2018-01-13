package cn.godbol.repository;

import cn.godbol.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by li on 2018-01-13 下午10:35.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

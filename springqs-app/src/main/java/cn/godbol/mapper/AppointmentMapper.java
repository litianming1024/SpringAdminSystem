package cn.godbol.mapper;

import cn.godbol.domain.Appointment;
import cn.godbol.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * Created by li on 2018-03-20 下午6:57.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppointmentMapper {

    @Mappings({
            @Mapping(source = "apply.id", target = "applyId"),
            @Mapping(source = "apply.applyStatus", target = "applyStatus"),
    })
    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);

    Collection<AppointmentDTO> appointmentsToAppointmentDTOs(Collection<Appointment> appointments);

    @Mappings({
            @Mapping(source = "applyId", target = "apply.id"),
            @Mapping(source = "applyStatus", target = "apply.applyStatus"),
    })
    Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO);

    Collection<Appointment> appointmentDTOsToAppointments(Collection<AppointmentDTO> appointmentDTOs);
    
}

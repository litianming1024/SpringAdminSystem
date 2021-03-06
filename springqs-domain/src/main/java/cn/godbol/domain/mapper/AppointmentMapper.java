package cn.godbol.domain.mapper;

import cn.godbol.domain.Appointment;
import cn.godbol.domain.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

/**
 * Created by li on 2018-03-20 下午6:57.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppointmentMapper {

    @Mappings({
            @Mapping(source = "apply.id", target = "applyId"),
            @Mapping(source = "apply.applyStatus", target = "applyStatus"),
            @Mapping(source = "apply.resume.id", target = "resumeId"),
            @Mapping(source = "apply.resume.basicInfo.name", target = "basicInfoName"),
            @Mapping(source = "apply.resume.basicInfo.tel", target = "basicInfoTel"),
    })
    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);

    List<AppointmentDTO> appointmentsToAppointmentDTOs(List<Appointment> appointments);

    @Mappings({
            @Mapping(source = "applyId", target = "apply.id"),
    })
    Appointment appointmentDTOToAppointment(AppointmentDTO appointmentDTO);

    Collection<Appointment> appointmentDTOsToAppointments(Collection<AppointmentDTO> appointmentDTOs);
    
}

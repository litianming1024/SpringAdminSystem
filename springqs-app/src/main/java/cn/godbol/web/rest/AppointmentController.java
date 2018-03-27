package cn.godbol.web.rest;

import cn.godbol.domain.Appointment;
import cn.godbol.domain.dto.AppointmentDTO;
import cn.godbol.domain.mapper.AppointmentMapper;
import cn.godbol.message.ResponseMessage;
import cn.godbol.query.QueryParam;
import cn.godbol.service.api.AppointmentService;
import cn.godbol.service.api.CrudService;
import cn.godbol.web.rest.impl.DefaultCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by li on 2018-03-21 下午3:02.
 */
@RestController
@RequestMapping(value = "/api/appointment")
public class AppointmentController implements DefaultCrudController<Appointment, Long, QueryParam, AppointmentDTO> {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentMapper appointmentMapper;


    @Override
    public CrudService<Appointment, Long> getService() {
        return appointmentService;
    }

    @Override
    public Appointment DTOToEntity(AppointmentDTO appointmentDTO) {
        return appointmentMapper.appointmentDTOToAppointment(appointmentDTO);
    }

    @Override
    public AppointmentDTO entityToDTO(Appointment appointment) {
        return appointmentMapper.appointmentToAppointmentDTO(appointment);
    }

    @GetMapping("/applyStatus")
    public ResponseMessage findAppointmentByApplyStatus(QueryParam queryParam, @RequestParam(name = "applyStatus[]") Collection<Integer> applyStatus) {
        return ResponseMessage.ok(appointmentService.findAppointmentByApplyStatus(applyStatus, queryParam.toPageRequest()).map(this::entityToDTO));
    }

//    @GetMapping("/apply/{id}")
//    public ResponseMessage findLatest(@PathVariable Long id) {
//        return ResponseMessage.ok(entityToDTO(appointmentService.findLatest(id)));
//    }
    @GetMapping("/applyAndInterview")
    public ResponseMessage findByApplyIdAndInterviewType(@RequestParam long applyId, @RequestParam int interviewType) {
        return ResponseMessage.ok(entityToDTO(appointmentService.findByApplyIdAndInterviewType(applyId, interviewType)));
    }
    @GetMapping("/needToInterview")
    public ResponseMessage findAppointmentsByInterviewTypeAndStatus(QueryParam queryParam, @RequestParam int interviewType, @RequestParam int status) {
        return ResponseMessage.ok(appointmentService.findAppointmentsByInterviewTypeAndStatus(interviewType, status, queryParam.toPageRequest()).map(this::entityToDTO));
    }
}

package cn.godbol.domain.mapper;

import cn.godbol.domain.*;
import cn.godbol.domain.dto.ApplyDTO;
import cn.godbol.domain.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by li on 2018-01-13 下午9:53.
 */
@Mapper(componentModel = "spring", uses = {AppointmentMapper.class})
public interface ApplyMapper {

    AppointmentMapper appointmentMapper = Mappers.getMapper(AppointmentMapper.class);
    //    @Mappings({
//            @Mapping(source = "resume.id", target = "resumeId"),
//            @Mapping(source = "recruitment.id", target = "recruitmentId"),
//            @Mapping(source = "recruitment.name", target = "recruitmentName"),
//            @Mapping(source = "resume.basicInfo.name", target = "basicInfoName"),
//    })
//    ApplyDTO applyToApplyDTO(Apply apply);
    default ApplyDTO applyToApplyDTO(Apply apply) {
        if (apply == null) {
            return null;
        }

        ApplyDTO applyDTO = new ApplyDTO();

        String name = applyRecruitmentName(apply);
        if (name != null) {
            applyDTO.setRecruitmentName(name);
        }
        String name1 = applyResumeBasicInfoName(apply);
        if (name1 != null) {
            applyDTO.setBasicInfoName(name1);
        }
        Long id = applyRecruitmentId(apply);
        if (id != null) {
            applyDTO.setRecruitmentId(id);
        }
        Long id1 = applyResumeId(apply);
        if (id1 != null) {
            applyDTO.setResumeId(id1);
        }
        if (apply.getId() != null) {
            applyDTO.setId(apply.getId());
        }
        List<AppointmentDTO> appointments = appointmentMapper.appointmentsToAppointmentDTOs(apply.getAppointments());

        applyDTO.setAppointments(appointments);
        applyDTO.setApplyStatus(apply.getApplyStatus());
        if (appointments != null && appointments.size() > 0) {
            appointments.sort(new Comparator<AppointmentDTO>() {
                @Override
                public int compare(AppointmentDTO o1, AppointmentDTO o2) {
                    return o2.getInterviewType() - o1.getInterviewType();
                }
            });
            applyDTO.setLatestAppointment(appointments.get(0));
        }
        return applyDTO;
    }

    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id"),
            @Mapping(source = "recruitmentId", target = "recruitment.id"),
//            @Mapping(target = "resume", ignore = true),
//            @Mapping(target = "recruitment", ignore = true)
    })
    Apply applyDTOToApply(ApplyDTO applyDTO);

    Collection<ApplyDTO> appliesToapplyDTOs(Collection<Apply> applies);

    Collection<Apply> applyDTOsToapplies(Collection<ApplyDTO> applyDTOS);

    default String applyRecruitmentName(Apply apply) {
        if ( apply == null ) {
            return null;
        }
        Recruitment recruitment = apply.getRecruitment();
        if ( recruitment == null ) {
            return null;
        }
        String name = recruitment.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    default String applyResumeBasicInfoName(Apply apply) {
        if ( apply == null ) {
            return null;
        }
        Resume resume = apply.getResume();
        if ( resume == null ) {
            return null;
        }
        BasicInfo basicInfo = resume.getBasicInfo();
        if ( basicInfo == null ) {
            return null;
        }
        String name = basicInfo.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    default Long applyRecruitmentId(Apply apply) {
        if ( apply == null ) {
            return null;
        }
        Recruitment recruitment = apply.getRecruitment();
        if ( recruitment == null ) {
            return null;
        }
        Long id = recruitment.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    default Long applyResumeId(Apply apply) {
        if ( apply == null ) {
            return null;
        }
        Resume resume = apply.getResume();
        if ( resume == null ) {
            return null;
        }
        Long id = resume.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

package cn.godbol.domain.mapper;

import cn.godbol.domain.Apply;
import cn.godbol.domain.dto.ApplyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午9:53.
 */
@Mapper(componentModel = "spring", uses = {AppointmentMapper.class})
public interface ApplyMapper {

    @Mappings({
            @Mapping(source = "resume.id", target = "resumeId"),
            @Mapping(source = "recruitment.id", target = "recruitmentId"),
            @Mapping(source = "recruitment.name", target = "recruitmentName"),
            @Mapping(source = "resume.basicInfo.name", target = "basicInfoName")
    })
    ApplyDTO applyToApplyDTO(Apply apply);

    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id"),
            @Mapping(source = "recruitmentId", target = "recruitment.id"),
//            @Mapping(target = "resume", ignore = true),
//            @Mapping(target = "recruitment", ignore = true)
    })
    Apply applyDTOToApply(ApplyDTO applyDTO);

    Collection<ApplyDTO> appliesToapplyDTOs(Collection<Apply> applies);
    Collection<Apply> applyDTOsToapplies(Collection<ApplyDTO> applyDTOS);
}

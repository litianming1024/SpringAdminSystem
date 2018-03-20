package cn.godbol.mapper;

import cn.godbol.domain.Apply;
import cn.godbol.dto.ApplyDTO;
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
            @Mapping(source = "recruitment.id", target = "recruitmentId")
    })
    ApplyDTO applyToApplyDTO(Apply apply);

    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id"),
            @Mapping(source = "recruitmentId", target = "recruitment.id")
    })
    Apply applyDTOToApply(ApplyDTO applyDTO);

    Collection<ApplyDTO> appliesToapplyDTOs(Collection<Apply> applies);
    Collection<Apply> applyDTOsToapplies(Collection<ApplyDTO> applyDTOS);
}

package cn.godbol.mapper;

import cn.godbol.domain.Recruitment;
import cn.godbol.dto.RecruitmentDTO;
import org.mapstruct.Mapper;

/**
 * Created by li on 2018-01-15 下午1:47.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RecruitmentMapper {
    RecruitmentDTO recruitmentToRecruitmentDTO(Recruitment recruitment);
    Recruitment recruitmentDTOToRecruitment(RecruitmentDTO resumeDTO);
}

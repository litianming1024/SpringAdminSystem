package cn.godbol.domain.mapper;

import cn.godbol.domain.Education;
import cn.godbol.domain.dto.EducationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * Created by li on 2018-03-14 下午4:49.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EducationMapper {
    @Mappings({
            @Mapping(source = "resume.id", target = "resumeId")
    })
    EducationDTO educationToEducationDTO(Education education);

    Collection<EducationDTO> educationsToEducationDTOs(Collection<Education> educations);

    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id")
    })
    Education educationDTOToEducation(EducationDTO educationDTO);

    Collection<Education> educationDTOsToEducations(Collection<EducationDTO> educationDTOs);
}

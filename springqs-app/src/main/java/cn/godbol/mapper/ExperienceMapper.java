package cn.godbol.mapper;

import cn.godbol.domain.Experience;
import cn.godbol.dto.ExperienceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * Created by li on 2018-03-12 下午5:14.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ExperienceMapper {
    @Mappings({
            @Mapping(source = "resume.id", target = "resumeId")
    })
    ExperienceDTO experienceToExperienceDTO(Experience experience);

    Collection<ExperienceDTO> experiencesToExperienceDTOs(Collection<Experience> experiences);

    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id")
    })
    Experience experienceDTOToExperience(ExperienceDTO experienceDTO);

    Collection<Experience> experienceDTOsToExperiences(Collection<ExperienceDTO> experienceDTOs);
}

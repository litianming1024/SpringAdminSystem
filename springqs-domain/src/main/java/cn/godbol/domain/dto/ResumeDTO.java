package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午9:57.
 */
@Getter
@Setter
public class ResumeDTO {
    private Long id;
    private BasicInfoDTO basicInfo;
    private Collection<EducationDTO> educations;
    private Collection<ExperienceDTO> experiences;
    private Collection<ApplyDTO> applies;
}

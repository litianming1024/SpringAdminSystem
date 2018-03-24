package cn.godbol.domain.mapper;

import cn.godbol.domain.Resume;
import cn.godbol.domain.dto.ResumeDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午11:12.
 */
@Mapper(componentModel = "spring", uses = {
        BasicInfoMapper.class,
        ExperienceMapper.class,
        EducationMapper.class,
        ApplyMapper.class})
public interface ResumeMapper {
    ResumeDTO resumeToResumeDTO(Resume resume);
    Resume resumeDTOToResume(ResumeDTO resumeDTO);
    Collection<ResumeDTO> resumesToResumeDTOs(Collection<Resume> resumes);
    Collection<Resume> resumesDTOsToResumes(Collection<ResumeDTO> resumeDTOS);
}

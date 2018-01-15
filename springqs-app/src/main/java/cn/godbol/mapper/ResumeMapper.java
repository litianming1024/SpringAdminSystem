package cn.godbol.mapper;

import cn.godbol.domain.Resume;
import cn.godbol.dto.ResumeDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午11:12.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResumeMapper {
    ResumeDTO resumeToResumeDTO(Resume resume);
    Resume resumeDTOToResume(ResumeDTO resumeDTO);
    Collection<ResumeDTO> resumesToResumeDTOs(Collection<Resume> resumes);
    Collection<Resume> resumesDTOsToResumes(Collection<ResumeDTO> resumeDTOS);
}

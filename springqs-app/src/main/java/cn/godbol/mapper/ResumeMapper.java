package cn.godbol.mapper;

import cn.godbol.domain.Resume;
import cn.godbol.dto.ResumeDTO;
import org.mapstruct.Mapper;

/**
 * Created by li on 2018-01-13 下午11:12.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResumeMapper {
    ResumeDTO resumeToResumeDTO(Resume resume);
    Resume resumeDTOToResume(ResumeDTO resumeDTO);
}

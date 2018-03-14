package cn.godbol.mapper;

import cn.godbol.domain.BasicInfo;
import cn.godbol.dto.BasicInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

/**
 * Created by li on 2018-03-07 下午3:04.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BasicInfoMapper {
    @Mappings({
            @Mapping(source = "resume.id", target = "resumeId")
    })
    BasicInfoDTO basicInfoToBasicInfoDTO(BasicInfo basicInfo);

    Collection<BasicInfoDTO> basicInfoiesToBasicInfoDTOs(Collection<BasicInfo> basicInfos);


    @Mappings({
            @Mapping(source = "resumeId", target = "resume.id")
    })
    BasicInfo basicInfoDTOToBasicInfo(BasicInfoDTO basicInfoDTO);

    Collection<BasicInfo> basicInfoDTOsToBasicInfos(Collection<BasicInfoDTO> basicInfoDTOs);
}

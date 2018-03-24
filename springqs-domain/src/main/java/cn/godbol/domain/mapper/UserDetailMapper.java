package cn.godbol.domain.mapper;

import cn.godbol.domain.UserDetail;

import cn.godbol.domain.dto.UserDetailDTO;
import org.mapstruct.Mapper;

/**
 * Created by li on 17-3-4.
 */
@Mapper(componentModel = "spring"/*, uses = {UserMapper.class}*/)
public interface UserDetailMapper {
    UserDetailDTO userDetailToUserDetailDTO(UserDetail userDetail);
    UserDetail userDetailDTOToUserDetail(UserDetailDTO userDetailDTO);
}

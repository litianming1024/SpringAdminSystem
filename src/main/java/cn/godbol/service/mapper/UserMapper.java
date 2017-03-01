package cn.godbol.service.mapper;

import cn.godbol.domain.User;
import cn.godbol.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * Created by li on 17-2-28.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    Collection<UserDTO> usersToUserDTOs(Collection<User> users);
}

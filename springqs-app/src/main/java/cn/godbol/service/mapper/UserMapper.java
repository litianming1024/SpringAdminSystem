package cn.godbol.service.mapper;

import cn.godbol.domain.Group;
import cn.godbol.dto.UserDTO;
import cn.godbol.jwt.domain.User;
import org.mapstruct.Mapper;
import java.util.Collection;

/**
 * Created by li on 17-2-28.
 */
@Mapper(componentModel = "spring", uses = {GroupMapper.class})
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    Collection<UserDTO> usersToUserDTOs(Collection<User> users);

    User userDTOToUser(UserDTO userDTO);

    Collection<User> userDTOsToUsers(Collection<UserDTO> userDTOs);

    default Group groupFromId(Long id){
        if (id == null){
            return null;
        }
        Group group = new Group();
        group.setId(id);
        return group;
    }
}

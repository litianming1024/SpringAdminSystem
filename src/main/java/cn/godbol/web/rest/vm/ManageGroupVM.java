package cn.godbol.web.rest.vm;

import cn.godbol.service.dto.GroupDTO;
import cn.godbol.service.dto.UserDTO;

import java.util.Collection;

/**
 * Created by li on 17-3-7.
 */
public class ManageGroupVM extends GroupDTO {
    private Collection<UserDTO> users;

    public Collection<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserDTO> users) {
        this.users = users;
    }
}

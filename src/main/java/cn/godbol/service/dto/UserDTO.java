package cn.godbol.service.dto;

import cn.godbol.domain.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by li on 17-2-28.
 */
@Getter @Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
//    private Collection<GroupDTO> groups;

    public UserDTO(Long id, String username, String password, boolean accountNonExpired, boolean accountNonLocked,
                   boolean credentialsNonExpired, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
}

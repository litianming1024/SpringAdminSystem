package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

/**
 * Created by li on 17-2-28.
 */
@Getter @Setter
public class UserDTO {
    private Long id;
    @NotNull
    private String username;
//    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<GroupDTO> groups;

    private String email;

    private String tel;
    //名字
    private String name;
    //身份证号
    private String idcard;

    private Integer sex;

    private Date birthday;

    private Collection<ResumeDTO> resumes;

    private UserDetailDTO userDetail;
    private String openId;
}

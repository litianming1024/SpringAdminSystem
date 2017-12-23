package cn.godbol.jwt.domain;

import cn.godbol.jwt.domain.BaseModel;
import cn.godbol.jwt.domain.api.UserApi;
import cn.godbol.jwt.domain.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Getter @Setter
@Table(name = "tb_user")
public class User extends BaseModel /*implements UserApi*/{

    @Column(length = 50)
    private String username;

    @JsonIgnore
    @Column(length = 50)
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "tb_users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Collection<Group> groups;

//    @OneToOne(mappedBy = "user")
//    private UserDetail userDetail;

}

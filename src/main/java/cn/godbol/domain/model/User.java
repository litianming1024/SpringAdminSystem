package cn.godbol.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Table(name = "tb_user")
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class User extends BaseModel {

    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    @ManyToMany
    @JoinTable(name = "tb_users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Collection<Group> groups;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;
}

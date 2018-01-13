package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Getter @Setter
@Table(name = "tb_user")
public class User extends BaseModel /*implements UserApi*/{

    @Column(length = 30)
    private String username;

    @Column(length = 30)
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String tel;
    //名字
    private String name;
    //身份证号
    private String idcard;

    private Character sex;
    //出生日期
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToMany
    @JoinTable(name = "tb_users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Collection<Group> groups;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "user")
    private Collection<Resume> resume;

}

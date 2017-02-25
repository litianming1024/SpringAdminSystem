package cn.godbol.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@Table(name = "tb_group")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Group extends BaseModel {

    @Column(length = 50)
    private String e_name;
    @Column(length = 50)
    private String c_name;
    //This is for father group and child group.
    private Long parent_id;
    private boolean has_child;

    @ManyToMany(mappedBy = "groups")
    private Collection<User> users;

    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    @ManyToMany
    @JoinTable(name = "tb_groups_authorities",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Collection<Authority> authorities;
}

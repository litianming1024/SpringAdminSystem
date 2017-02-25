package cn.godbol.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Table(name = "tb_authority")
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Authority extends BaseModel {

    @Column(length = 50)
    private String c_name;

    @Column(length = 50)
    private String e_name;
    private Long parent_id;
    private boolean has_child;

    @Column(length = 50)
    private String url;

    @Column(length = 50)
    private String icon;

    private Long sort;

    @ManyToMany(mappedBy = "authorities")
    private Collection<Group> groups;
}

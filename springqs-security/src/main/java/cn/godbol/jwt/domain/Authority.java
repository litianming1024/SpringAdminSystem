package cn.godbol.jwt.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Getter @Setter
@Entity
@Table(name = "tb_authority")
public class Authority extends BaseModel {

    @Column(length = 50)
    private String c_name;

    @Column(length = 50)
    private String e_name;
    private Long parent_id;
    private boolean has_child;
    private String method;

    @Column(length = 50)
    private String url;

    @Column(length = 50)
    private String icon;

    private Long sort;

    @ManyToMany(mappedBy = "authorities")
    private Collection<Group> groups;


}

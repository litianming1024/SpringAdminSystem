package cn.godbol.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Table(name = "tb_authority")
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

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public boolean isHas_child() {
        return has_child;
    }

    public void setHas_child(boolean has_child) {
        this.has_child = has_child;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }
}

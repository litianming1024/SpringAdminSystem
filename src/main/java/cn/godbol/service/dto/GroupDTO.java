package cn.godbol.service.dto;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
public class GroupDTO {
    private Long id;
    private String e_name;
    private String c_name;
    //This is for father group and child group.
    private Long parent_id;
    private boolean has_child;

    private Collection<AuthorityDTO> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
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

    public Collection<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }
}

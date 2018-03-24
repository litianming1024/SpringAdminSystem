package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by li on 17-3-1.
 */
@Getter @Setter
public class GroupDTO {
    private Long id;
    private String e_name;
    private String c_name;
    //This is for father group and child group.
    private Long parent_id;
    private boolean has_child;

    private Collection<AuthorityDTO> authorities;

}

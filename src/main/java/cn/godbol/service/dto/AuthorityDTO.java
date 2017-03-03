package cn.godbol.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by li on 17-3-1.
 */
@Getter @Setter
public class AuthorityDTO {

    private Long id;

    private String c_name;

    private String e_name;
    private Long parent_id;
    private boolean has_child;

    private String url;

    private String icon;

    private Long sort;

    public AuthorityDTO() {
    }
}

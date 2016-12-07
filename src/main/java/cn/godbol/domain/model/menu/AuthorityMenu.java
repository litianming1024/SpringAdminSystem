package cn.godbol.domain.model.menu;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by Li on 2016/11/19.
 */
@Getter @Setter
public class AuthorityMenu {

    private String c_name;
    private String e_name;
    private String url;
    private String icon;
    private Collection<AuthorityMenu> children;

    public AuthorityMenu(String c_name, String e_name, String url, String icon) {
        this.c_name = c_name;
        this.e_name = e_name;
        this.url = url;
        this.icon = icon;
    }
}

package cn.godbol.domain;


import cn.godbol.jwt.domain.BaseModel;
import cn.godbol.jwt.domain.User;

import javax.persistence.*;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Table(name = "tb_userdetail")
public class UserDetail extends BaseModel {

    //中文名
    @Column(length = 50)
    private String c_name;
    @Column(length = 50)
    private String telephone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

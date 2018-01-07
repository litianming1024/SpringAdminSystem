package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by li on 2017-12-28 下午4:59.
 * 个人信息表
 */
@Entity
@Table
@Setter @Getter
public class BasicInfo extends BaseModel {
    //名字
    private String name;
    //身份证号
    private String idcard;
    //电话
    private String tel;
    private Character sex;
    //出生日期
    @Temporal(TemporalType.DATE)
    private Date birthday;
    //婚姻状况
    private String marry;
    private String email;
    //期望薪资
    private String salary;
    //现居城市
    private String address;
    //相片位置
    private String photoPath;

    @OneToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

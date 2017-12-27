package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.crypto.Data;

/**
 * Created by li on 2017-12-26 下午4:04.
 */
//@Entity
//@Table(name = "tb_resume")
@Getter @Setter
public class Resume extends BaseModel {

    //名字
    private String name;

    //电话
    private String tel;
    private Character sex;
    //婚姻状况
    private String marry;
    private String email;
    //期望薪资
    private String salary;
    private String address;
    //入校时间
    private Data educationStartTime;
    //毕业时间
    private Data educationEndTime;
    //学校
    private String schoolName;
    //学历
    private String education;
    //学位
    private String degree;
    //专业
    private String major;

}

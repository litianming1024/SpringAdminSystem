package cn.godbol.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by li on 2018-01-13 下午9:56.
 */
@Getter @Setter
public class BasicInfoDTO {
    private Long id;

    private String name;
    //身份证号
    private String idcard;
    //电话
    private String tel;
    private Character sex;
    //出生日期
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

    private ResumeDTO resume;
}

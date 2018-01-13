package cn.godbol.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by li on 2018-01-13 下午9:56.
 */
@Getter
@Setter
public class EducationDTO {
    private Long id;
    private Date educationStartTime;
    //毕业时间
    private Date educationEndTime;
    //学校
    private String schoolName;
    //学历
    private String education;
    //学位
    private String degree;
    //专业
    private String major;
}

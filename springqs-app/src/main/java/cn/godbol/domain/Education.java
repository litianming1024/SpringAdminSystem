package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by li on 2017-12-28 下午4:58.
 * 教育背景表
 */
@Entity
@Table
@Setter
@Getter
public class Education extends BaseModel{
    //入校时间
    @Temporal(TemporalType.DATE)
    private Date educationStartTime;
    //毕业时间
    @Temporal(TemporalType.DATE)
    private Date educationEndTime;
    //学校
    private String schoolName;
    //学历
    private String education;
    //学位
    private String degree;
    //专业
    private String major;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

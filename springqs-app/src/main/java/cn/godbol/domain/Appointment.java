package cn.godbol.domain;

import cn.godbol.domain.enumvalue.InterviewMethod;
import cn.godbol.domain.enumvalue.InterviewType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by li on 2017-12-29 下午6:39.
 * 面试预约
 */
@Entity
@Table
@Setter
@Getter
public class Appointment extends BaseModel {
    @ManyToOne
    private Apply apply;
    //预约面试时间
    @Temporal(TemporalType.DATE)
    private Date interviewTime;
    //签到
    private Boolean result;
    //面试方式
    private InterviewMethod interviewMethod;
    //面试评价
    private String comment;
    //面试类型


}

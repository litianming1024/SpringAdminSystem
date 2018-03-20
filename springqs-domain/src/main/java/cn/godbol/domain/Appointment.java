package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;


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
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar interviewTime;
    //签到
    private Boolean result = false;
    //面试方式
//    @Enumerated(EnumType.ORDINAL)
//    private InterviewMethod interviewMethod;
    //面试评价
    private String comment;
    //面试类型
//    @Enumerated(EnumType.ORDINAL)
//    private InterviewType interviewType;

}

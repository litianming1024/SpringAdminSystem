package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar interviewTime;

    //签到时间
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar presentTime;

    //面试方式
//    @Enumerated(EnumType.ORDINAL)
//    private InterviewMethod interviewMethod;
    //面试评价
    private String comment;
    //面试类型
    private int interviewType;

    //面试地点
    private String place;

    private int status;
}

package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by li on 2018-01-13 下午9:56.
 */
@Getter @Setter
public class AppointmentDTO {
    private long id;
    private long applyId;
    private long resumeId;
    //预约面试时间
    private Calendar interviewTime;
    private int applyStatus;
    //签到
//    private Boolean result;
    //面试方式
//    private InterviewMethod interviewMethod;
    //面试评价
    private String comment;
    //面试类型
//    private InterviewType interviewType;
    private int interviewType;
    private Calendar presentTime;
    private String place;
    private int status = 0;
}

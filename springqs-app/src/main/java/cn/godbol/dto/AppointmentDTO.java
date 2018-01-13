package cn.godbol.dto;

import cn.godbol.domain.enumvalue.InterviewMethod;
import cn.godbol.domain.enumvalue.InterviewType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by li on 2018-01-13 下午9:56.
 */
@Getter @Setter
public class AppointmentDTO {
    private Long id;
    private ApplyDTO apply;
    //预约面试时间
    private Date interviewTime;
    //签到
    private Boolean result;
    //面试方式
    private InterviewMethod interviewMethod;
    //面试评价
    private String comment;
    //面试类型
    private InterviewType interviewType;
}

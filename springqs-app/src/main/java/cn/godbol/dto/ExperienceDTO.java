package cn.godbol.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by li on 2018-01-13 下午9:57.
 */
@Getter
@Setter
public class ExperienceDTO {
    private Long id;
    private String projectName;
    //开始时间
    private Date workStartTime;
    //结束时间
    private Date workEndTime;
    //工作职责
    private String responsibility;
}

package cn.godbol.domain.dto;

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
    private Date startTime;
    //结束时间
    private Date endTime;
    //工作职责
    private String responsibility;
    //职位名称
    private String positionName;
    //公司名称
    private String companyName;
    //工作性质
    private int workType;

    private long resumeId;
}

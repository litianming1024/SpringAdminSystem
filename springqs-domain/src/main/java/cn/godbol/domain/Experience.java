package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by li on 2017-12-28 下午5:04.
 * 实习经历
 */
@Entity
@Table
@Setter @Getter
public class Experience extends BaseModel {
    //项目名称
    private String projectName;
    //开始时间
    @Temporal(TemporalType.DATE)
    private Date startTime;
    //结束时间
    @Temporal(TemporalType.DATE)
    private Date endTime;
    //工作职责
    private String responsibility;
    //职位名称
    private String positionName;
    //公司名称
    private String companyName;
    //工作性质
    private int workType;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}

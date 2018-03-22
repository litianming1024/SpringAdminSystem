package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by li on 2017-12-29 下午3:32.
 * 申请记录
 */
@Entity
@Table
@Setter @Getter
public class Apply extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @OneToMany(mappedBy = "apply", cascade = {CascadeType.ALL})
    private Collection<Appointment> appointments;
    //投递状态
//    @Enumerated(EnumType.ORDINAL)
//    private ApplyStatus applyStatus;
    private int applyStatus = 0;
}

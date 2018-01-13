package cn.godbol.dto;

import cn.godbol.domain.enumvalue.ApplyStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by li on 2018-01-13 下午9:55.
 */
@Getter @Setter
public class ApplyDTO {
    private ResumeDTO resume;

    private RecruitmentDTO recruitment;

    private Collection<AppointmentDTO> appointments;
    //投递状态
    private ApplyStatus applyStatus;
}

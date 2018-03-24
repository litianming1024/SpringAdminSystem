package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by li on 2018-01-13 下午9:57.
 */
@Getter
@Setter
public class RecruitmentDTO {
    private Long id;
    private String name;
    //工作地点
    private String workplace;
    //职位类别
    private String category;
    //工作职责
    private String responsibility;
    //工作要求
    private String requirement;
    //招聘团队
    private String team;
    private Integer status;
}

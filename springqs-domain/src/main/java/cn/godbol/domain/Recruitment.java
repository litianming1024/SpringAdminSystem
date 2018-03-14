package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by li on 2017-12-28 下午4:47.
 * 招聘信息
 */
@Entity
@Table
@Getter @Setter
public class Recruitment extends BaseModel{
    //职位名称
    @Column(length = 30)
    private String name;
    //工作地点
    @Column(length = 50)
    private String workplace;
    //职位类别
    @Column(length = 30)
    private String category;
    //工作职责
    private String responsibility;
    //工作要求
    private String requirement;
    //招聘团队
    private String team;
    private Integer status;
//    @ManyToMany(mappedBy = "recruitments")
//    private Collection<Resume> resumes;
    @OneToMany(mappedBy = "recruitment")
    private Collection<Apply> applies;

}

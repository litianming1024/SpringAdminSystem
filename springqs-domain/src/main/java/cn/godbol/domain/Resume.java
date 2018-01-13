package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by li on 2017-12-26 下午4:04.
 * 简历
 */
@Entity
@Table
@Getter @Setter
public class Resume extends BaseModel{
    @OneToOne(mappedBy = "resume")
    private BasicInfo basicInfo;
    @OneToMany(mappedBy = "resume")
    private Collection<Education> educations;
    @OneToMany(mappedBy = "resume")
    private Collection<Experience> experiences;
//    @ManyToMany
//    @JoinTable(name = "apply", joinColumns = @JoinColumn(name = "resume_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "recruitment_id", referencedColumnName = "id"))
//    private Collection<Recruitment> recruitments;
    @OneToMany(mappedBy = "resume")
    private Collection<Apply> applies;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

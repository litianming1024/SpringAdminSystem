package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by li on 2017-12-26 下午4:04.
 * 简历
 */
@Entity
@Table
@Getter @Setter
public class Resume extends BaseModel{
    @OneToOne(mappedBy = "resume", cascade = {CascadeType.ALL})
    private BasicInfo basicInfo;
    @OneToMany(mappedBy = "resume", cascade = {CascadeType.ALL})
    private Collection<Education> educations = new HashSet<>();
    @OneToMany(mappedBy = "resume", cascade = {CascadeType.ALL})
    private Collection<Experience> experiences = new HashSet<>();
//    @ManyToMany
//    @JoinTable(name = "apply", joinColumns = @JoinColumn(name = "resume_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "recruitment_id", referencedColumnName = "id"))
//    private Collection<Recruitment> recruitments;
    @OneToMany(mappedBy = "resume", cascade = {CascadeType.ALL})
    private Collection<Apply> applies;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

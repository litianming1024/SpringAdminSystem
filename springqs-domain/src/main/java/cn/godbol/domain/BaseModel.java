package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
public abstract class BaseModel implements Comparable<BaseModel>,Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Temporal(TemporalType.DATE)
    protected Date createDate;

    @Temporal(TemporalType.DATE)
    protected Date updateDate;

    @Override
    public int compareTo(BaseModel o) {
        return this.getId().compareTo(o.getId());
    }

}
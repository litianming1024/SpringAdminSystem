package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Comparable<BaseModel>,Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    protected Calendar createDate;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    protected Calendar updateDate;

    @Override
    public int compareTo(BaseModel o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getPrimaryKey() {
        return id;
    }

}
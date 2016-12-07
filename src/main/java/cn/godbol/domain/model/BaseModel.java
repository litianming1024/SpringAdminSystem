package cn.godbol.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter @Setter
public abstract class BaseModel implements Comparable<BaseModel>,Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Override
    public int compareTo(BaseModel o) {
        return this.getId().compareTo(o.getId());
    }
}
package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by li on 2018-03-24 下午4:33.
 */
@Getter
@Setter
@Table
@Entity
public class QRcode extends BaseModel{
    @Column(nullable = true)
    private int expireSeconds;
    @Column(nullable = true)
    private int actionName;
    @Column(nullable = true)
    private int sceneId;
    private String sceneStr;
    private String ticket;
}

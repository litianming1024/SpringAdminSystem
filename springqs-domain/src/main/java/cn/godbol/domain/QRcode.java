package cn.godbol.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by li on 2018-03-24 下午4:33.
 */
@Getter
@Setter
@Table
@Entity
public class QRcode{

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Column(nullable = true)
    private int expireSeconds;

    @Column(nullable = true)
    private int actionName;

    @Column(nullable = true)
    private int sceneId;

    private String sceneStr;
    private String ticket;
    //成功签到人数
    private int count = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createTime = Calendar.getInstance();
}

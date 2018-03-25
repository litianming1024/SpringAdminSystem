package cn.godbol.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by li on 2018-03-24 下午4:50.
 */
@Getter @Setter
public class QRcodeDTO {
    private int expireSeconds;
    private int actionName;
    private int sceneId;
    private String sceneStr;
    private String ticket;
    private int count;
    protected Calendar createTime;
}

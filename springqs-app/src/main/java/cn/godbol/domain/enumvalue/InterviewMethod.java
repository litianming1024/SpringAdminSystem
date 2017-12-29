package cn.godbol.domain.enumvalue;

import lombok.Getter;


/**
 * Created by li on 2017-12-29 下午7:07.
 */
@Getter
public enum  InterviewMethod {
    REMOTE("远程"),
    ONSITE("现场"),
    TELEPHONE("电话");

    private String method;

    InterviewMethod(String s) {
        method = s;
    }
}

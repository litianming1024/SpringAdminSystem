package cn.godbol.domain.enumvalue;

import lombok.Getter;

/**
 * Created by li on 2017-12-29 下午7:35.
 */
@Getter
public enum InterviewType {
    FIRST("初试"),
    RETEST("复试"),
    HR("HR面试");

    private String type;

    InterviewType(String s) {
        type =s;
    }
}

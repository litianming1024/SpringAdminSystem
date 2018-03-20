package cn.godbol.domain.enumvalue;

import lombok.Getter;

/**
 * Created by li on 2017-12-29 下午7:41.
 */
@Getter
public enum ApplyStatus {
    SCREENING("筛选中"), PASS("筛选通过");
    private String status;

    ApplyStatus(String s) {
        status = s;
    }
}

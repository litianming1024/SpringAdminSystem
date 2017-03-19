package cn.godbol.common.service.exception;

import lombok.Getter;

/**
 * Created by li on 17-3-18.
 */
@Getter
public enum ServerErrorConstant {
    CREATE("create"), DELETE("delete"), UPDATE("update"), QUERY("query");

    private String action;

    ServerErrorConstant(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }
}

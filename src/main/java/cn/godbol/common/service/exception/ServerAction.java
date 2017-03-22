package cn.godbol.common.service.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by li on 17-3-18.
 */
@Getter @ToString
public enum ServerAction {
    CREATE("create"), DELETE("delete"), UPDATE("update"), QUERY("query");

    private final String action;

    ServerAction(String action) {
        this.action = action;
    }

//    @Override
//    public String toString() {
//        return action;
//    }
}

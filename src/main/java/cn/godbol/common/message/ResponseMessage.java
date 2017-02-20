package cn.godbol.common.message;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
@Setter
@Getter
public class ResponseMessage implements Serializable{
    /**
     * 反馈数据
     */
    private Object data;

    /**
     * 响应码
     */
    private int code;

    /**
     * 反馈信息
     */
    private String message;

    public static ResponseMessage ok(Object data) {
        ResponseMessage message = new ResponseMessage();
        message.setCode(200);
        message.setData(data);
        return message;
    }
}

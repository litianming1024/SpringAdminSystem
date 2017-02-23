package cn.godbol.common.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by li on 17-2-23.
 */
public class ResponseEntityBuilder {
    /**
     * 反馈数据
     */
    private Object data;

    /**
     * 反馈信息
     */
    private String message;


    public static ResponseEntity<Map<String, Object>> find(Object data) {
        Map<String, Object> map = new HashMap<>();
        if (data != null)
            map.put("data", data);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

}

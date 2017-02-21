package cn.godbol.common.message;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by li on 17-2-20.
 */
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

    /**
     * 过滤字段：指定需要序列化的字段
     */
    private transient Map<Class<?>, Set<String>> includes;

    /**
     * 过滤字段：指定不需要序列化的字段
     */
    private transient Map<Class<?>, Set<String>> excludes;

    private transient boolean onlyData;

    private transient String callback;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (data != null)
            map.put("data", this.getData());
        if (message != null)
            map.put("message", this.getMessage());
        map.put("code", this.getCode());
        return map;
    }

    protected ResponseMessage() {
    }


    public ResponseMessage include(Class<?> type, String... fields) {
        return include(type, Arrays.asList(fields));
    }

    public ResponseMessage include(Class<?> type, Collection<String> fields) {
        if (includes == null)
            includes = new HashMap<>();
        if (fields == null || fields.isEmpty()) return this;
        fields.forEach(field -> {
            if (field.contains(".")) {
                String tmp[] = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        include(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFromMap(includes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage exclude(Class type, Collection<String> fields) {
        if (excludes == null)
            excludes = new HashMap<>();
        if (fields == null || fields.isEmpty()) return this;
        fields.forEach(field -> {
            if (field.contains(".")) {
                String tmp[] = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        exclude(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFromMap(excludes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage exclude(Collection<String> fields) {
        if (excludes == null)
            excludes = new HashMap<>();
        if (fields == null || fields.isEmpty()) return this;
        Class type;
        if (data != null) type = data.getClass();
        else return this;
        exclude(type, fields);
        return this;
    }

    public ResponseMessage include(Collection<String> fields) {
        if (includes == null)
            includes = new HashMap<>();
        if (fields == null || fields.isEmpty()) return this;
        Class type;
        if (data != null) type = data.getClass();
        else return this;
        include(type, fields);
        return this;
    }

    public ResponseMessage exclude(Class type, String... fields) {
        return exclude(type, Arrays.asList(fields));
    }

    public ResponseMessage exclude(String... fields) {
        return exclude(Arrays.asList(fields));
    }

    public ResponseMessage include(String... fields) {
        return include(Arrays.asList(fields));
    }

    protected Set<String> getStringListFromMap(Map<Class<?>, Set<String>> map, Class type) {
        return map.computeIfAbsent(type, k -> new HashSet<>());
    }

    public Object getData() {
        return data;
    }

    public ResponseMessage setData(Object data) {
        this.data = data;
        return this;
    }

//    @Override
//    public String toString() {
//        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
//    }

    public int getCode() {
        return code;
    }

    public ResponseMessage setCode(int code) {
        this.code = code;
        return this;
    }

//    public static ResponseMessage fromJson(String json) {
//        return JSON.parseObject(json, ResponseMessage.class);
//    }

    public Map<Class<?>, Set<String>> getExcludes() {
        return excludes;
    }

    public Map<Class<?>, Set<String>> getIncludes() {
        return includes;
    }

    public ResponseMessage onlyData() {
        setOnlyData(true);
        return this;
    }

    public void setOnlyData(boolean onlyData) {
        this.onlyData = onlyData;
    }

    public boolean isOnlyData() {
        return onlyData;
    }

    public ResponseMessage callback(String callback) {
        this.callback = callback;
        return this;
    }

    public String getCallback() {
        return callback;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResponseMessage ok() {
        return ok(null);
    }

    public static ResponseMessage ok(Object data) {
        ResponseMessage message = new ResponseMessage();
        message.setCode(200);
        message.setData(data);
        return message;
    }

    public static ResponseMessage created(Object data) {
        ResponseMessage message = new ResponseMessage();
        message.setCode(201);
        message.setData(data);
        return message;
    }

    public static ResponseMessage error(String message) {
        return error(message, 500);
    }

    public static ResponseMessage error(String message, int code) {
        ResponseMessage response = new ResponseMessage();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}

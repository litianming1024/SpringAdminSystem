package cn.godbol.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * axios对于Response格式的定义
 * {
 // `data` is the response that was provided by the server
 data: {},

 // `status` is the HTTP status code from the server response
 status: 200,

 // `statusText` is the HTTP status message from the server response
 statusText: 'OK',

 // `headers` the headers that the server responded with
 // All header names are lower cased
 headers: {},

 // `config` is the config that was provided to `axios` for the request
 config: {},

 // `request` is the request that generated this response
 // It is the last ClientRequest instance in node.js (in redirects)
 // and an XMLHttpRequest instance the browser
 request: {}
 }
 * Created by li on 2017-12-27 下午6:32.
 */

@Getter @Setter
public class ResponseMessage<T> implements Serializable {

    //数据
    private T data;
    //状态码
    private int status;
    //状态信息
    private String statusText;
    private Long timestamp;

    private Collection<String> headers;
    private Collection<String> config;
    private Collection<String> request;

    public ResponseMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    public ResponseMessage<T> statusText(String statusText) {
        this.statusText = statusText;
        return this;
    }

    public ResponseMessage<T> data(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseMessage<T> error(String statusText) {
        return error(500, statusText);
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public static <T> ResponseMessage<T> error(int status, String statusText) {
        return new ResponseMessage<T>().status(status).statusText(statusText).putTimeStamp();
    }

    public static <T> ResponseMessage<T> ok(T data) {
        return new ResponseMessage<T>()
                .data(data)
                .putTimeStamp()
                .status(200)
                .statusText("OK");
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    /**
     * 过滤字段：指定需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> includes;

    /**
     * 过滤字段：指定不需要序列化的字段
     */
    @JsonIgnore
    private transient Map<Class<?>, Set<String>> excludes;


    public ResponseMessage<T> include(Class<?> type, String... fields) {
        return include(type, Arrays.asList(fields));
    }

    public ResponseMessage<T> include(Class<?> type, Collection<String> fields) {
        if (includes == null) {
            includes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
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

    public ResponseMessage<T> exclude(Class type, Collection<String> fields) {
        if (excludes == null) {
            excludes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
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

    public ResponseMessage<T> exclude(Collection<String> fields) {
        if (excludes == null) {
            excludes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        Class type;
        if (data != null) {
            type = data.getClass();
        } else {
            return this;
        }
        exclude(type, fields);
        return this;
    }

    public ResponseMessage<T> include(Collection<String> fields) {
        if (includes == null) {
            includes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        Class type;
        if (data != null) {
            type = data.getClass();
        } else {
            return this;
        }
        include(type, fields);
        return this;
    }

    public ResponseMessage<T> exclude(Class type, String... fields) {
        return exclude(type, Arrays.asList(fields));
    }

    public ResponseMessage<T> exclude(String... fields) {
        return exclude(Arrays.asList(fields));
    }

    public ResponseMessage<T> include(String... fields) {
        return include(Arrays.asList(fields));
    }

    protected Set<String> getStringListFromMap(Map<Class<?>, Set<String>> map, Class type) {
        return map.computeIfAbsent(type, k -> new HashSet<>());
    }

}

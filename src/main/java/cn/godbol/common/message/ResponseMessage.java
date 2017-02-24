package cn.godbol.common.message;

import java.io.Serializable;

/**
 * Created by li on 17-2-20.
 */
public class ResponseMessage implements Serializable{
//    public static ResponseMessage error(String message) {
//        return error(500, message);
//    }
//
//    public static ResponseMessage error(int status, String message) {
//        ResponseMessage msg = new ResponseMessage();
//        msg.put("message", message);
//        msg.put("status", status);
//        return msg.putTimeStamp();
//    }
//
//    public static ResponseMessage ok() {
//        return ok(null);
//    }
//
//    private ResponseMessage putTimeStamp() {
//        put("timestamp", System.currentTimeMillis());
//        return this;
//    }
//
//    public static ResponseMessage ok(Object data) {
//        return new ResponseMessage()
//                .data(data)
//                .putTimeStamp()
//                .status(200);
//    }
//
//    public ResponseMessage and(String key, Object value) {
//        put(key, value);
//        return this;
//    }
//
//    public ResponseMessage data(Object data) {
//        if (data != null)
//            put("data", data);
//        return this;
//    }
//
//    /**
//     * 过滤字段：指定需要序列化的字段
//     */
//    private transient Map<Class<?>, Set<String>> includes;
//
//    /**
//     * 过滤字段：指定不需要序列化的字段
//     */
//    private transient Map<Class<?>, Set<String>> excludes;
//
//    protected ResponseMessage() {
//    }
//
//    public ResponseMessage include(Class<?> type, String... fields) {
//        return include(type, Arrays.asList(fields));
//    }
//
//    public ResponseMessage include(Class<?> type, Collection<String> fields) {
//        if (includes == null)
//            includes = new HashMap<>();
//        if (fields == null || fields.isEmpty()) return this;
//        fields.forEach(field -> {
//            if (field.contains(".")) {
//                String tmp[] = field.split("[.]", 2);
//                try {
//                    Field field1 = type.getDeclaredField(tmp[0]);
//                    if (field1 != null) {
//                        include(field1.getType(), tmp[1]);
//                    }
//                } catch (Throwable e) {
//                }
//            } else {
//                getStringListFromMap(includes, type).add(field);
//            }
//        });
//        return this;
//    }
//
//    public ResponseMessage exclude(Class type, Collection<String> fields) {
//        if (excludes == null)
//            excludes = new HashMap<>();
//        if (fields == null || fields.isEmpty()) return this;
//        fields.forEach(field -> {
//            if (field.contains(".")) {
//                String tmp[] = field.split("[.]", 2);
//                try {
//                    Field field1 = type.getDeclaredField(tmp[0]);
//                    if (field1 != null) {
//                        exclude(field1.getType(), tmp[1]);
//                    }
//                } catch (Throwable e) {
//                }
//            } else {
//                getStringListFromMap(excludes, type).add(field);
//            }
//        });
//        return this;
//    }
//
//    public ResponseMessage exclude(Collection<String> fields) {
//        if (excludes == null)
//            excludes = new HashMap<>();
//        if (fields == null || fields.isEmpty()) return this;
//        Class type;
//        if (getData() != null) type = getData().getClass();
//        else return this;
//        exclude(type, fields);
//        return this;
//    }
//
//    public ResponseMessage include(Collection<String> fields) {
//        if (includes == null)
//            includes = new HashMap<>();
//        if (fields == null || fields.isEmpty()) return this;
//        Class type;
//        if (getData() != null) type = getData().getClass();
//        else return this;
//        include(type, fields);
//        return this;
//    }
//
//    public ResponseMessage exclude(Class type, String... fields) {
//        return exclude(type, Arrays.asList(fields));
//    }
//
//    public ResponseMessage exclude(String... fields) {
//        return exclude(Arrays.asList(fields));
//    }
//
//    public ResponseMessage include(String... fields) {
//        return include(Arrays.asList(fields));
//    }
//
//    protected Set<String> getStringListFromMap(Map<Class<?>, Set<String>> map, Class type) {
//        return map.computeIfAbsent(type, k -> new HashSet<>());
//    }
//
//    public Object getData() {
//        return get("data");
//    }
//
//
//    @Override
//    public String toString() {
//        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
//    }
//
//    public ResponseMessage status(int status) {
//        put("status", status);
//        return this;
//    }
//
//    public Map<Class<?>, Set<String>> getExcludes() {
//        return excludes;
//    }
//
//    public Map<Class<?>, Set<String>> getIncludes() {
//        return includes;
//    }
}

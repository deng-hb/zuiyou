package com.denghb.zuiyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by denghb on 2017/4/12.
 */
public class JacksonUtils {

    private static Logger log = LoggerFactory.getLogger(JacksonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Object -> JSON String
     *
     * @param object
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * JSON String -> Object
     *
     * @param json
     * @param clazz
     * @param <T>
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * JSON String -> Map<String, Object>
     *
     * @param json
     * @param <T>
     */
    public static <T> Map<String, Object> toMap(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * JSON String -> Map<String, T>
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        try {
            Map<String, Map<String, Object>> map = objectMapper.readValue(json,
                    new TypeReference<Map<String, T>>() {
                    });
            Map<String, T> result = new HashMap<String, T>();
            for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
                result.put(entry.getKey(), mapToObject(entry.getValue(), clazz));
            }
            return result;

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * JSON String -> List<Map<String, Object>>
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        try {
            List<Map<String, Object>> list = objectMapper.readValue(json,
                    new TypeReference<List<T>>() {
                    });
            List<T> result = new ArrayList<T>();
            for (Map<String, Object> map : list) {
                result.add(mapToObject(map, clazz));
            }
            return result;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Map -> Object
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T mapToObject(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}

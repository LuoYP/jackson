package com.jackson.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author LuoYP
 */
public class JacksonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String objectToString(T object) {
        if (Objects.isNull(object)) {
            return null;
        }
        try {
            return object instanceof String ? (String) object : objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Parse Object to String error,object{}", object);
            return null;
        }
    }

    public static <T> T StringToObject(String json, Class<T> clazz) {
        if(StringUtils.isEmpty(json) || clazz == null){
            return null;
        }

        try {
            return clazz.equals(String.class)? (T)json : objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            LOGGER.error("Parse String to Object error",e);
            return null;
        }
    }

}

package com.jackson.demo.utils;

import com.jackson.demo.model.Student;
import org.junit.jupiter.api.Test;

/**
 * @author LuoYP
 */
public class JacksonTest {

    @Test
    public void objectToString(){
        Student student = new Student();
        student.setAdult(false);
        String result = JacksonUtil.objectToString(student);
        System.out.println(result);
    }

    @Test
    public void stringToObject(){
        String json = "{\"adult\":1}";
        Student student = JacksonUtil.StringToObject(json, Student.class);
        System.out.println(student);
    }
}

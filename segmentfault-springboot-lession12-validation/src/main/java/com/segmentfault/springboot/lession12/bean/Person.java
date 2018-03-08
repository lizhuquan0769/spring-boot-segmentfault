package com.segmentfault.springboot.lession12.bean;

import com.segmentfault.springboot.lession12.validation.bean.PersonNamePrefix;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by lizhuquan on 2018/3/8.
 */
public class Person {

    @NotNull
    @PersonNamePrefix(prefix = "segmentfault-")
    private String name;

    @Min(value = 0)
    @Max(value = 100)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

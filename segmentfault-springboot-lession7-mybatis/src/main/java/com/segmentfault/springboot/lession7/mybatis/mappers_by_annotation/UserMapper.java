package com.segmentfault.springboot.lession7.mybatis.mappers_by_annotation;

import com.segmentfault.springboot.lession7.entity_by_annotation.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "desc_json", property = "desc")
    })
    @Select("SELECT id,name,age,desc_json FROM user WHERE id=#{userId}")
    User findUserById(int userId);
}

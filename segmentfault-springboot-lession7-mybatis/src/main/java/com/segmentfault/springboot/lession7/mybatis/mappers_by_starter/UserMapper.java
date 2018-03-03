package com.segmentfault.springboot.lession7.mybatis.mappers_by_starter;


import com.segmentfault.springboot.lession7.entity_by_starter.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserById(int userId);
}

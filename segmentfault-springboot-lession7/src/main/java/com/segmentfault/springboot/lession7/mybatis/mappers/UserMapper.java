package com.segmentfault.springboot.lession7.mybatis.mappers;

import com.segmentfault.springboot.lession7.entity.User;

public interface UserMapper {

    User findUserById(int userId);
}

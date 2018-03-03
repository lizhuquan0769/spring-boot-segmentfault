package com.segmentfault.springboot.lession7;

import com.segmentfault.springboot.lession7.entity_by_starter.User;
import com.segmentfault.springboot.lession7.mybatis.mappers_by_starter.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable Integer userId) {
        User userByStarter = null;

        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        userByStarter = mapper.findUserById(userId);

        return userByStarter;
    }
}

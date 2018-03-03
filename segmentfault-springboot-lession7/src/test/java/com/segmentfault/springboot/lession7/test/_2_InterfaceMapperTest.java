package com.segmentfault.springboot.lession7.test;

import com.segmentfault.springboot.lession7.entity.User;
import com.segmentfault.springboot.lession7.mybatis.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.InputStreamReader;


public class _2_InterfaceMapperTest {

    public static void main(String[] args) throws Exception {
        EncodedResource encodedResource = new EncodedResource(new ClassPathResource("mybatis/mybatis-configuration.xml"), "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(new InputStreamReader(encodedResource.getInputStream(), "utf-8"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // mapper接口方式调用
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);
    }

}

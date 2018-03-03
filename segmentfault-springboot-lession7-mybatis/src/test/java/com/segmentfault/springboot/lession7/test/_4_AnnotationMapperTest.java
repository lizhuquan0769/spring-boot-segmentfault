package com.segmentfault.springboot.lession7.test;

import com.segmentfault.springboot.lession7.entity_by_generator.User;
import com.segmentfault.springboot.lession7.mybatis.mappers_by_annotation.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _4_AnnotationMapperTest {

    public static void main(String[] args) throws IOException {
        EncodedResource encodedResource = new EncodedResource(new ClassPathResource("mybatis/mybatis-configuration.xml"), "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(new InputStreamReader(encodedResource.getInputStream(), "utf-8"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // annotation方式调用
        UserMapper userMapperByAnnotation = sqlSession.getMapper(UserMapper.class);
        com.segmentfault.springboot.lession7.entity_by_annotation.User user = userMapperByAnnotation.findUserById(1);
        System.out.println(user);

    }
}

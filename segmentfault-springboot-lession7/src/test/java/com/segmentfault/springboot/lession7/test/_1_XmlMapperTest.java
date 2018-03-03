package com.segmentfault.springboot.lession7.test;

import com.segmentfault.springboot.lession7.entity.User;
import com.segmentfault.springboot.lession7.mybatis.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.InputStream;
import java.io.InputStreamReader;


public class _1_XmlMapperTest {

    public static void main(String[] args) throws Exception {
        EncodedResource encodedResource = new EncodedResource(new ClassPathResource("mybatis/mybatis-configuration.xml"), "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(new InputStreamReader(encodedResource.getInputStream(), "utf-8"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // namespace.statment方式调用
        User user1 = (User)sqlSession.selectOne("com.segmentfault.springboot.lession7.mybatis.mappers.UserMapper.findUserById", 1);
        System.out.println(user1);
    }

}

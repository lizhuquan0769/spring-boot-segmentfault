package com.segmentfault.springboot.lession7.test;

import com.segmentfault.springboot.lession7.entity_by_generator.User;
import com.segmentfault.springboot.lession7.entity_by_generator.UserExample;
import com.segmentfault.springboot.lession7.mybatis.mappers_by_generator.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _3_GeneratorMapperTest {

    public static void main(String[] args) throws IOException {
        EncodedResource encodedResource = new EncodedResource(new ClassPathResource("mybatis/mybatis-configuration.xml"), "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(new InputStreamReader(encodedResource.getInputStream(), "utf-8"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // generator生成的代码调用
        UserMapper userMapperByGenerator = sqlSession.getMapper(UserMapper.class);

        User user = userMapperByGenerator.selectByPrimaryKey(1);
        System.out.println(user);
    }
}

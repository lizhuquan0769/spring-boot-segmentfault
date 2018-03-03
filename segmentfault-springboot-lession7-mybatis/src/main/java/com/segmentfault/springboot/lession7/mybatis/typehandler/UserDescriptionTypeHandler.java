package com.segmentfault.springboot.lession7.mybatis.typehandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.segmentfault.springboot.lession7.entity.User;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDescriptionTypeHandler implements TypeHandler<User.UserDescription> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, User.UserDescription userDescription, JdbcType jdbcType) throws SQLException {
        StringWriter sw = new StringWriter();
        try {
            objectMapper.writeValue(sw, userDescription);
        } catch (IOException e) {
            throw new SQLException(e);
        }
        preparedStatement.setString(i, sw.toString());
    }

    @Override
    public User.UserDescription getResult(ResultSet resultSet, String column) throws SQLException {
        String descJson = resultSet.getString(column);

        return parseDescJson(descJson);
    }

    @Override
    public User.UserDescription getResult(ResultSet resultSet, int i) throws SQLException {
        String descJson = resultSet.getString(i);

        return parseDescJson(descJson);
    }

    private User.UserDescription parseDescJson(String descJson) {
        User.UserDescription desc = null;
        if (StringUtils.hasLength(descJson)) {
            try {
                desc = objectMapper.readValue(descJson, User.UserDescription.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return desc;
    }

    @Override
    public User.UserDescription getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}

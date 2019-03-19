package com.springboot.mapper;

import com.springboot.Model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(Integer id);
    List<User> getAllUser();
}

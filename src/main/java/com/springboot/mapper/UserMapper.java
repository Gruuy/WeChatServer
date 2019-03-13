package com.springboot.mapper;

import com.springboot.Model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(Integer id);
}

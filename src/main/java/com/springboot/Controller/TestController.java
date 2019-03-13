package com.springboot.Controller;

import com.springboot.Model.User;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @ResponseBody
    @RequestMapping("/test")
    public User test(){
        User user=userMapper.getUser(1);
        return user;
    }
}

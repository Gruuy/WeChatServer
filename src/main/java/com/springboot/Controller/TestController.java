package com.springboot.Controller;

import com.springboot.Model.User;
import com.springboot.Service.RequestURL;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RequestURL requestURL;

    @ResponseBody
    @RequestMapping("/test")
    public User test(){
        User user=userMapper.getUser(1);
        return user;
    }
    @ResponseBody
    @RequestMapping("/WeChatlogin")
    public String wxlogin(@Param("code") String code){
        return requestURL.wxlogin(code);
    }
}

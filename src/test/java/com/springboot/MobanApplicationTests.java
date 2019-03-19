package com.springboot;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.Model.User;
import com.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MobanApplicationTests {
    //自动注入返回值为JedisPool的对象
    @Autowired
    JedisPool jedisPool;

    @Autowired
    UserMapper userMapper;
    @Test
    public void testPageHelper() {
        PageHelper.startPage(1,1);
        List<User> list=userMapper.getAllUser();
        PageInfo<User> page=new PageInfo<User>(list);
        System.out.println(page.getList().get(0).getId());
        System.out.println(page.getList().get(0).getUsername());
        System.out.println(page.getList().get(0).getPassword());
        System.out.println(page.getList().get(0).getLevel());
    }
    @Test
    public void testJedis(){
        System.out.println(jedisPool.getResource().get("Gruuy"));
    }
}

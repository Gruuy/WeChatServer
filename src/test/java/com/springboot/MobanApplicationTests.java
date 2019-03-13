package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MobanApplicationTests {
    @Autowired
    JedisPool jedisPool;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testJedis(){
        System.out.println(jedisPool.getResource().get("Gruuy"));
    }
}

package com.springboot.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Component
public class RequestURL {
    @Autowired
    JedisPool jedisPool;
    public String wxlogin(String code){
        Jedis jedis=jedisPool.getResource();
        RestTemplate restTemplate=new RestTemplate();
        String url="https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=wxf8a38f5ef3cec263&" +
                "secret=e64ebc221a5e291b55e657044dcfca50"+
                "&js_code="+code+
                "&grant_type=authorization_code";
        JSONObject body= JSON.parseObject(restTemplate.getForObject(url,String.class));
        System.out.println(body.get("session_key"));
        String key= RandomStringUtils.randomAlphanumeric(64);
        System.out.println(key);

        jedis.set(key,body.toJSONString(),"NX","EX",7200);
        System.out.println(jedis.get(key));
        jedis.close();
        return key;
    }
}

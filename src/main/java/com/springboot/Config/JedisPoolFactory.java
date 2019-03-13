package com.springboot.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//定义为配置类
@Configuration
public class JedisPoolFactory {
    //自动注入RedisProperties的配置文件(application-dev.yaml里面的配置)
    @Autowired
    private RedisProperties properties;
    @Bean
    public JedisPool getJedisPool(){
        //新建一个Jedis配置类
        JedisPoolConfig config=new JedisPoolConfig();
        //从配置文件中获取对应的值，赋入配置类之中
        config.setMinIdle(properties.getJedis().getPool().getMinIdle());
        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
        //利用配置类，以及获取地址和端口，获取一个Jedis池对象
        JedisPool pool=new JedisPool(config,properties.getHost(),properties.getPort());
        //返回注入！
        return pool;
    }
}

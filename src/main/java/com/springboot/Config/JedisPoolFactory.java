package com.springboot.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisPoolFactory {
    @Autowired
    private RedisProperties properties;
    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMinIdle(properties.getJedis().getPool().getMinIdle());
        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
        JedisPool pool=new JedisPool(config,properties.getHost(),properties.getPort());
        return pool;
    }
}

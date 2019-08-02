package com.zemic.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Redis {

    @Autowired
    private StringRedisTemplate template;

    /**
     * @param key
     * @param value
     * @param expire 为过期时间，秒为单位
     */
    public void set(String key, String value, long expire) {
        template.opsForValue().set(key, value, expire, TimeUnit.MILLISECONDS);
    }

    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public Object get(String key){
        return template.opsForValue().get(key);
    }

    public void delete(String key){
        template.delete(key);
    }
}

package lq.study.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void setValue(String key,String value){
        redisTemplate.opsForValue().set(key,value,10, TimeUnit.SECONDS);
    }

    public String getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }


}

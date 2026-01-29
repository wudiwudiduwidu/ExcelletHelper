package com.yupi.mianshiya.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RedissonConfig {
@Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;

// 无密码
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setTimeout(2000)
                .setDatabase(0);
        return Redisson.create(config);
    }
}


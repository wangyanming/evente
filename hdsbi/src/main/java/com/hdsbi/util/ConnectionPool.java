package com.hdsbi.util;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value = "jdbc.properties")
public class ConnectionPool {
	
	@Bean(destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "clickhouse.jdbc")
	public DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		return dataSource;
	}
	
	@Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        // redis value使用的序列化器
        template.setValueSerializer(new KryoSerializer<>(Object.class));
        // redis key使用的序列化器
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }

}

package com.hdsbi.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUtils<T> {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 写入redis
	 * @param req
	 * @param obj
	 */
	public void writeToRedis(Object req, Object obj) {
		redisTemplate.opsForValue().set(req, obj, 1, TimeUnit.DAYS);
	}
	
	/**
	 * 获取value
	 * @param key
	 * @return
	 */
	public Object getValues(Object key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 判断Key是否存在
	 * @param key
	 * @return
	 */
	public boolean hasKey(Object key) {
		return redisTemplate.hasKey(key);
	}
	
	/**
	 * 清空db
	 */
	public void flushDb() {
		redisTemplate.execute(new RedisCallback<T>() {

			@Override
			public T doInRedis(RedisConnection conn) throws DataAccessException {
				conn.flushDb();
				return null;
			}
			
		});
	}
	
	public static void main(String[] args) {
		
	}
}

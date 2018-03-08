package com.segmentfault.springboot.lession10.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Arrays;

/**
 * Created by lizhuquan on 2018/3/7.
 */
@Configuration
@EnableCaching
public class CacheManagerConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        ConcurrentMapCache personCache = new ConcurrentMapCache("persons");
        ConcurrentMapCache carCache = new ConcurrentMapCache("cars");

        RedisCacheManager redisCacheManager = new RedisCacheManager(null);
        redisCacheManager.setTransactionAware(true);

        cacheManager.setCaches(Arrays.asList(personCache, carCache));

        return cacheManager;
    }


}

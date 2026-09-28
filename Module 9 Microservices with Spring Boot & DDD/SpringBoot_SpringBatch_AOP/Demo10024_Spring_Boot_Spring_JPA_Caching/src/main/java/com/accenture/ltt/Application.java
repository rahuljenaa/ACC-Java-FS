package com.accenture.ltt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Step3: for enabling caching cache management support..
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Step2: Cache manager implementation
	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cache = new ConcurrentMapCacheManager("empCacheSpace");
		// parameter empCacheSpace is the name of the cache
		// in production environment cache manager that is used is:
		// GuavaCache, EHCache and RedisCache
		return cache;
	}

}
//https://stackoverflow.com/questions/12113725/how-do-i-tell-spring-cache-not-to-cache-null-value-in-cacheable-annotation
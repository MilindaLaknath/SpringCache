package com.sample.cache.springcache.service;

import com.sample.cache.springcache.cache.SimpleCache;
import com.sample.cache.springcache.cache.SimpleCacheFactory;
import com.sample.cache.springcache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class SimpleCacheService {

    private final SimpleCache cache;

    private String level;
    private String strategy;
    private int maxsize;

    @Autowired
    SimpleCacheService(Environment env){
        level = env.getProperty("cache.level");
        strategy = env.getProperty("cache.strategy");
        maxsize = Integer.parseInt(env.getProperty("cache.maxsize"));
        cache = SimpleCacheFactory.getInstance(level,strategy, maxsize);
    }

    public void insertValue(User user){
        cache.put(user.getId(), user);
    }

    public User getValue(String key){
        try {
            return (User) cache.get(key);
        }catch (ClassCastException e){
            return null;
        }
    }

}

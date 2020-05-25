package com.sample.cache.springcache.controller;

import com.sample.cache.springcache.model.User;
import com.sample.cache.springcache.service.SimpleCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cache")
public class CacheController {

    private final SimpleCacheService cacheService;

    @Autowired
    public CacheController(SimpleCacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping
    public void addToCache(@RequestBody User user){
        cacheService.insertValue(user);
    }

    @GetMapping
    public User getUserFromCache(@RequestParam String id){
        return cacheService.getValue(id);
    }

}

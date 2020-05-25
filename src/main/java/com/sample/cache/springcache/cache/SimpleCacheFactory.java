package com.sample.cache.springcache.cache;

import com.sample.cache.springcache.cache.impl.Constants;
import com.sample.cache.springcache.cache.impl.FileCache;
import com.sample.cache.springcache.cache.impl.InMemCache;

public class SimpleCacheFactory {

    private static SimpleCache cache;

    //getInstance
    private SimpleCacheFactory(){}

    private static void createInstance(String level, String strategy, int memSize){
        if(Constants.FILE_CACHE.equals(level)){
            cache = new FileCache(memSize,strategy);
        }else {
            cache = new InMemCache(memSize,strategy);
        }
    }

    public static SimpleCache getInstance(String level, String strategy, int memSize){
        if (cache==null) {
            createInstance(level, strategy, memSize);
        }
        return cache;
    }

}

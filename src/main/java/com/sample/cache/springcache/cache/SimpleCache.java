package com.sample.cache.springcache.cache;

public interface SimpleCache {
    void put(String key, Object value);
    Object get(String key);
    void viewCache();
}

package com.sample.cache.springcache.service;

import com.sample.cache.springcache.cache.SimpleCache;
import com.sample.cache.springcache.cache.SimpleCacheFactory;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SimpleCacheServiceTest {

    Logger log = LogManager.getLogger(SimpleCacheServiceTest.class);

    public final static String LRU = "LRU";
    public final static String LFU = "LFU";

    public final static String MEM_CACHE = "memory";
    public final static String FILE_CACHE = "file";

    public final static int MAX_SIZE = 5;

    @Test
    public void memCacheLRUTest(){

        SimpleCache inMemCache = SimpleCacheFactory.getInstance(MEM_CACHE,LRU,MAX_SIZE);
        inMemCache.put("1","One");
        inMemCache.put("2","Two");
        inMemCache.put("3","Three");
        inMemCache.put("4","Four");
        try {
            /*
             * Use thread sleep to wait few mili-second to increase the current time in mili-second
             * */
            Thread.sleep(100);
        }catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        inMemCache.get("1");
        inMemCache.get("3");
        inMemCache.put("5","Five");
        inMemCache.get("1");
        inMemCache.put("6","Six");
        inMemCache.put("7","Seven");

        inMemCache.viewCache();
    }

    @Test
    public void memCacheLFUTest(){

        SimpleCache inMemCache = SimpleCacheFactory.getInstance(MEM_CACHE,LFU,MAX_SIZE);
        inMemCache.put("1","One");
        inMemCache.put("2","Two");
        inMemCache.put("3","Three");
        inMemCache.put("4","Four");
        inMemCache.get("1");
        inMemCache.get("3");
        inMemCache.put("5","Five");
        inMemCache.get("1");
        inMemCache.put("6","Six");
        inMemCache.put("7","Seven");

        inMemCache.viewCache();
    }

    @Test
    public void fileCacheLRUTest(){
        SimpleCache fileCache = SimpleCacheFactory.getInstance(FILE_CACHE,LRU,MAX_SIZE);
        fileCache.put("1","One");
        fileCache.put("2","Two");
        fileCache.put("3","Three");
        fileCache.put("4","Four");
        try {
            /*
            * Use thread sleep to wait few mili-second to increase the current time in mili-second
            * */
            Thread.sleep(10);
        }catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        fileCache.get("1");
        fileCache.get("3");
        fileCache.put("5","Five");
        fileCache.get("1");
        fileCache.put("6","Six");
        fileCache.put("7","Seven");

        fileCache.viewCache();
    }

    @Test
    public void fileCacheLFUTest(){
        SimpleCache fileCache = SimpleCacheFactory.getInstance(FILE_CACHE,LFU,MAX_SIZE);
        fileCache.put("1","One");
        fileCache.put("2","Two");
        fileCache.put("3","Three");
        fileCache.put("4","Four");
        fileCache.get("1");
        fileCache.get("3");
        fileCache.put("5","Five");
        fileCache.get("1");
        fileCache.put("6","Six");
        fileCache.put("7","Seven");

        fileCache.viewCache();
    }

}

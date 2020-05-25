package com.sample.cache.springcache.cache.impl;

import java.io.Serializable;

public class WrapValue implements Serializable {
    private Object value;

    WrapValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

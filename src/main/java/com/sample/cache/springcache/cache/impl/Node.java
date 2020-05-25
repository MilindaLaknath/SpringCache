package com.sample.cache.springcache.cache.impl;

public class Node {

    private Object value;
    private long updatedTime;
    private int frequency;

    Node(Object value){
        this.value = value;
        this.updatedTime = System.currentTimeMillis();
        this.frequency++;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void updateAccessedTime() {
        this.updatedTime = System.currentTimeMillis();
    }

    public int getFrequency() {
        return frequency;
    }

    public void updateFrequency() {
        this.frequency++;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", updatedTime=" + updatedTime +
                ", frequency=" + frequency +
                '}';
    }
}

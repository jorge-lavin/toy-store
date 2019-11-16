package com.lavinj87.toy_store;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryToyStore implements ToyStore
{
    private final ConcurrentHashMap<String, String> store;

    public InMemoryToyStore() {
        store = new ConcurrentHashMap<>();
    }

    @Override
    public long size() {
        return store.size();
    }

    @Override
    public void set(String key, String value) {
        store.put(key, value);
    }

    @Override
    public String get(String key) {
        return store.get(key);
    }

    @Override
    public void del(String key) {
        store.remove(key);
    }
}

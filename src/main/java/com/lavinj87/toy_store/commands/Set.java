package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Set implements Command {
    private final ToyStore store;
    private final String key;
    private final String value;


    public Set(ToyStore store, String key, String value) {
        this.key = key;
        this.store = store;
        this.value = value;
    }

    @Override
    public void execute() {
        store.set(key, value);
    }
}


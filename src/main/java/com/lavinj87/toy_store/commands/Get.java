package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Get implements Command {
    private final ToyStore store;
    private final String key;
    private String value;

    public Get(ToyStore store, String key) {
        this.key = key;
        this.store = store;
    }

    @Override
    public void execute() {
        value = store.get(key);
    }

    public String getValue() {
        return value;
    }
}

package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Size implements Command {

    private final ToyStore store;
    private long size;

    public Size(ToyStore store) {
        this.store = store;
    }

    @Override
    public void execute() {
        size = store.size();
    }

    public long getSize() {
        return size;
    }
}

package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Set extends Command
{
    private final String key;
    private final String value;

    public Set(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public Response execute(ToyStore store) {
        store.set(this.key, this.value);
        return new Response(key + " set to " + value);
    }
}


package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Get extends Command
{
    private final String key;

    public Get(String key)
    {
        this.key = key;
    }

    @Override
    public Response execute(ToyStore store)
    {
        return new Response(store.get(key));
    }
}

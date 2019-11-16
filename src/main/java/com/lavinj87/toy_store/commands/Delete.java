package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Delete extends Command
{
    private final String key;

    public Delete(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    @Override
    public Response execute(ToyStore store)
    {
        store.del(key);
        return new Response(key + " deleted");
    }
}

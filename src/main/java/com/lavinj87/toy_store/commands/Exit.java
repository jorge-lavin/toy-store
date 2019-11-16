package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public class Exit extends Command
{
    @Override
    public Response execute(ToyStore store)
    {
        return new Response("Exiting ...");
    }
}

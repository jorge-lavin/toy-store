package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

public abstract class Command
{
    public abstract Response execute(ToyStore store);
}

package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

/**
 * Represents a {@link ToyStore} command.
 */
public interface Command {

    /**
     * Executes the command.
     */
    void execute();
}

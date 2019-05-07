package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

import java.util.Objects;

/**
 * Represents a set {@link Command}
 *
 * @see ToyStore#set(String, String)
 */
public class Set implements Command {

    /**
     * The actual store.
     */
    private final ToyStore store;

    /**
     * The key to set.
     */
    private final String key;

    /**
     * The value to set.
     */
    private final String value;


    /**
     * Constructor.
     *
     * @param store See {@link #store}
     * @param key   See {@link #key}
     * @param value See {@link #value}
     */
    public Set(ToyStore store, String key, String value) {
        this.key = key;
        this.store = store;
        this.value = value;
    }

    @Override
    public void execute() {
        store.set(key, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Set)) return false;

        Set other = (Set) obj;
        return Objects.equals(store, other.store) && Objects.equals(key, other.key) && Objects.equals(value, other.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(key, store, value);
    }
}


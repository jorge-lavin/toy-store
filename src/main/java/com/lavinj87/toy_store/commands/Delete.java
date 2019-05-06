package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

import java.util.Objects;

/**
 * Represents a delete {@link Command}
 *
 * @see ToyStore#del(String)
 */
public class Delete implements Command {

    /**
     * The actual store.
     */
    private final ToyStore store;

    /**
     * The key to delete.
     */
    private final String key;

    /**
     * Constructor.
     *
     * @param store See {@link #store}
     * @param key   See {@link #key}
     */
    public Delete(ToyStore store, String key) {
        this.store = store;
        this.key = key;
    }

    @Override
    public void execute() {
        store.del(key);
    }

    /**
     * @return the key to be deleted.
     */
    public String getKey() {
        return key;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Delete)) return false;

        Delete other = (Delete) obj;
        return Objects.equals(store, other.store) && Objects.equals(key, other.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, key);
    }
}

package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

import java.util.Objects;

/**
 * Represents a get {@link Command}
 *
 * @see ToyStore#get(String)
 */
public class Get implements Command {

    /**
     * The actual store.
     */
    private final ToyStore store;

    /**
     * The key to get
     **/
    private final String key;

    /**
     * The value of the key(may be null)
     */
    private String value;

    /**
     * Constructor.
     *
     * @param store See {@link #store}
     * @param key   See {@link #key}
     */
    public Get(ToyStore store, String key) {
        this.key = key;
        this.store = store;
    }

    @Override
    public void execute() {
        value = store.get(key);
    }

    /**
     * @return See {@link #value}
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Get)) return false;

        Get other = (Get) obj;
        return Objects.equals(store, other.store) && Objects.equals(key, other.key) && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, key, value);
    }
}

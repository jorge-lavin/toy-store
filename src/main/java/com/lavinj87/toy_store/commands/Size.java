package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;

import java.util.Objects;

/**
 * Represents a size {@link Command}
 *
 * @see ToyStore#size()
 */
public class Size implements Command {

    /**
     * The actual store.
     */
    private final ToyStore store;

    /**
     * The size of the store.
     */
    private long size;

    /**
     * Constructor.
     * @param store Ver {@link #store}
     */
    public Size(ToyStore store) {
        this.store = store;
    }

    @Override
    public void execute() {
        size = store.size();
    }

    /**
     * @return The size of the store.
     */
    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Size)) return false;

        Size other = (Size) obj;
        return Objects.equals(store, other.store) && Objects.equals(size, other.size);

    }

    @Override
    public int hashCode() {
        return Objects.hash(store, size);
    }
}

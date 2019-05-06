package com.lavinj87.toy_store;

import java.util.HashMap;

/**
 * The contract that enforces the store.
 */
public interface ToyStore {
    /**
     * @return The number of keys in the store.
     */
    long size();

    /**
     * Assigns the key with the value.
     * @param key   The key
     * @param value The value
     */
    void set(String key, String value);

    /**
     * @param key The key
     * @return The value assigned to that key or null.
     */
    String get(String key);

    /**
     * Deletes the value assigned to that key
     * @param key
     */
    void del(String key);

    /**
     * A {@link HashMap} backed testing store implementation. Dont use in production
     */
    class FakeToyStore implements ToyStore {

        /**
         * The internal store.
         */
        private final HashMap<String, String> store;

        /**
         * Constructor.
         *
         * @param store {@link #store}
         */
        public FakeToyStore(HashMap<String, String> store) {
            this.store = store;
        }

        /**
         * Constructor. Uses {@code new HashMap} as {@link #store}
         */
        public FakeToyStore()
        {
            this(new HashMap<>());
        }

        @Override
        public long size() {
            return store.size();
        }

        @Override
        public void set(String key, String value) {
            store.put(key, value);
        }

        @Override
        public String get(String key) {
            return store.get(key);
        }

        @Override
        public void del(String key) {
            store.remove(key);
        }
    }
}

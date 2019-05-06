package com.lavinj87.toy_store;

import org.junit.Assert;
import org.junit.Test;


public class FakeStoreTest {
    @Test
    public void testSize()
    {
        ToyStore store = new ToyStore.FakeToyStore();
        Assert.assertEquals(0, store.size());
        store.set("foo", "bar");
        store.set("another-foo", "another-bar");

        Assert.assertEquals(2, store.size());
    }

}
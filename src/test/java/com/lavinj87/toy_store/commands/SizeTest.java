package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;
import org.junit.Assert;
import org.junit.Test;

public class SizeTest {

    @Test
    public void testExecute() {
        ToyStore store = new ToyStore.FakeToyStore();
        store.set("foo", "bar");
        Assert.assertEquals("bar", store.get("foo"));

        Size storeSize = new Size(store);
        storeSize.execute();

        Assert.assertEquals(1, storeSize.getSize());
    }

    @Test
    public void testEquals() {
        ToyStore store = new ToyStore.FakeToyStore();
        Size storeSize = new Size(store);
        Size storeSizeAgain = new Size(store);

        Assert.assertNotSame(storeSize, storeSizeAgain);
        Assert.assertEquals(storeSize, storeSizeAgain);
        Assert.assertEquals(storeSize.hashCode(), storeSizeAgain.hashCode());

    }


}
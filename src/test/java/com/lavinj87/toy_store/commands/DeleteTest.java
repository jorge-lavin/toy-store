package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;
import org.junit.Assert;
import org.junit.Test;

public class DeleteTest {

    @Test
    public void testExecute() {
        ToyStore store = new ToyStore.FakeToyStore();
        store.set("foo", "bar");
        Assert.assertEquals("bar", store.get("foo"));

        Delete delete = new Delete(store, "foo");
        delete.execute();

        Assert.assertNull(store.get(delete.getKey()));
    }

    @Test
    public void testEquals() {
        ToyStore store = new ToyStore.FakeToyStore();
        Delete delete = new Delete(store, "foo");
        Delete deleteAgain = new Delete(store, "foo");

        Assert.assertNotSame(delete, deleteAgain);
        Assert.assertEquals(delete, deleteAgain);
        Assert.assertEquals(delete.hashCode(), deleteAgain.hashCode());
    }
}
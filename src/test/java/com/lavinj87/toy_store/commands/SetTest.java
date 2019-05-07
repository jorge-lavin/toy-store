package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;
import org.junit.Assert;
import org.junit.Test;

public class SetTest {

    @Test
    public void testExecute() {
        ToyStore store = new ToyStore.FakeToyStore();
        Assert.assertNull(store.get("foo"));
        
        Set setFooToBar = new Set(store, "foo", "bar");
        setFooToBar.execute();

        Assert.assertEquals("bar", store.get("foo"));
    }

    @Test
    public void testEquals() {
        ToyStore store = new ToyStore.FakeToyStore();
        Set setFooToBar = new Set(store, "foo", "bar");
        Set setFooToBarAgain = new Set(store, "foo", "bar");
        
        Assert.assertNotSame(setFooToBar, setFooToBarAgain);
        Assert.assertEquals(setFooToBar, setFooToBarAgain);
        Assert.assertEquals(setFooToBar.hashCode(), setFooToBarAgain.hashCode());
    }
}
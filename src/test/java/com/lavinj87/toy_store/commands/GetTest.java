package com.lavinj87.toy_store.commands;

import com.lavinj87.toy_store.ToyStore;
import org.junit.Assert;
import org.junit.Test;

public class GetTest {

    @Test
    public void testExecute() {
        ToyStore store = new ToyStore.FakeToyStore();
        store.set("foo", "bar");
        Assert.assertEquals("bar", store.get("foo"));

        Get getFoo = new Get(store, "foo");
        getFoo.execute();

        Assert.assertEquals("bar", getFoo.getValue());
        Get getNull = new Get(store, "not-foo");
        getNull.execute();
        
        Assert.assertNull(getNull.getValue());
    }
    
    @Test
    public void testEquals() {
        ToyStore store = new ToyStore.FakeToyStore();
        Get getFoo = new Get(store, "foo");
        Get getFooAgain = new Get(store, "foo");

        Assert.assertNotSame(getFoo, getFooAgain);
        Assert.assertEquals(getFoo, getFooAgain);
        Assert.assertEquals(getFoo.hashCode(), getFooAgain.hashCode());

    }


}
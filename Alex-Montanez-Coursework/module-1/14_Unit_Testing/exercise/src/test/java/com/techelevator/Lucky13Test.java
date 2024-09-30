package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Lucky13Test {

    @Test
    public void contains_no_1_or_3() {
        Lucky13 result = new Lucky13();
        Assert.assertTrue("There are no 1s or 3s in the array",
                result.getLucky(new int[] {10, 4, 5, 6}));
        Assert.assertFalse("There is a 1 or 3 in the array",
                result.getLucky(new int[] {10, 4, 3, 1, 9}));
    }
}

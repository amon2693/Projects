package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test
    public void is_first_and_last_the_same() {
        SameFirstLast result = new SameFirstLast();
        Assert.assertTrue("The array length is greater than 1 and the first and last elements are equal",
                result.isItTheSame(new int[]{9, 3, 9}));
        Assert.assertFalse("The array length is greater than 1, but the first and last elements aren't equal",
                result.isItTheSame(new int[]{9, 3, 4}));
    }
}

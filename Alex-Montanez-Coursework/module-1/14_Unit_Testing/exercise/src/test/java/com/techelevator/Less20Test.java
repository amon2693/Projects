package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void is_true_when_1_or_2_less_than_20() {
        Less20 number = new Less20();
        Assert.assertTrue("The number is 1 or 2 less than multiple of 20",
                number.isLessThanMultipleOf20(19));
        Assert.assertFalse("The number is not 1 or 2 less than multiple of 20",
                number.isLessThanMultipleOf20(40));
    }
}

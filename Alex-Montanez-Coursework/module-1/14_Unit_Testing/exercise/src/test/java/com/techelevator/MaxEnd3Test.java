package com.techelevator;

import org.junit.Test;

import java.util.Arrays;

public class MaxEnd3Test {


    @Test
    public void largest_number_in_array() {
        MaxEnd3 result = new MaxEnd3();
        assert Arrays.equals(result.makeArray (new int[] {100, 30, 400}), new int[] {400, 400, 400});
        assert Arrays.equals(result.makeArray (new int[] {300, 12, 96}), new int[] {300, 300, 300});
    }
}

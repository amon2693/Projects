package com.techelevator;

import org.junit.Test;

public class NonStartTest {

    @Test
    public void strings_together_minus_first_letter() {
        NonStart result = new NonStart();
        assert result.getPartialString("Hello", "Alex").equals("ellolex");
    }
}

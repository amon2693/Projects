package com.techelevator;

import org.junit.Test;

public class StringBitsTest {
    @Test
    public void every_other_word() {
        StringBits result = new StringBits();
        assert result.getBits("Hello").equals("Hlo");
    }
}

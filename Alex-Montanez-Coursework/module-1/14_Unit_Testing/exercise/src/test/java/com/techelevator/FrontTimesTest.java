package com.techelevator;

import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void find_front_number_of_times() {
        FrontTimes finder = new FrontTimes();
        assert finder.generateString("ah", 3).equals("ahahah");
        assert finder.generateString("hahaha", 2).equals("hahhah");
    }
}

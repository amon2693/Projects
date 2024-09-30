package com.techelevator;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class DateFashionTest {

    @Test
    public void will_get_a_table() {
        DateFashion style = new DateFashion();

        assert style.getATable(4, 7) == 1;
        assert  style.getATable(8, 3) == 2;
        assert style.getATable(2, 10) == 0;

    }


}

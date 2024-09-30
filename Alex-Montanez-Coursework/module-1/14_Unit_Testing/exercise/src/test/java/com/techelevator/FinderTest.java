package com.techelevator;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

public class FinderTest {

    @Test
    public void find_largest_number() {
        Finder largestNumber = new Finder();
        assert largestNumber.findLargest(Arrays.asList()) == null;
        assert largestNumber.findLargest(Arrays.asList(1, 5, 30, 400, 3000)) == 3000;
    }
}

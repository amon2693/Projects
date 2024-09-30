package com.techelevator;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class CigarPartyTest {


    @Test
    public void is_it_the_weekend() {
        CigarParty weekend = new CigarParty();
        Assert.assertTrue("It's the weekend, let's party!", weekend.haveParty(70, true));
        Assert.assertFalse("We don't have enough cigars to be celebrating",
                weekend.haveParty(28, true));
    }

    @Test
    public void test_number_of_cigars_on_weekday(){
        CigarParty weekday = new CigarParty();
        Assert.assertFalse("It is the weekday, but we don't have the proper number of cigars",
                weekday.haveParty(30, false));
        Assert.assertTrue("We have the proper amount of cigars to celebrate on a weekday!",
                weekday.haveParty(45, false));
    }
}

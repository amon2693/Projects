package com.techelevator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BD {
    public static void main(String[] args) {
        BigDecimal pi = new BigDecimal("3.1416");
        System.out.println(pi);
        BigDecimal point3 = new BigDecimal(.1 + .2);
        System.out.println(point3);

        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal one = BigDecimal.ONE;

        //doing math
        //BigDecimal is immutable
        System.out.println(subtotal.add(BigDecimal.ONE));
        System.out.println(subtotal.subtract(BigDecimal.ONE));
        subtotal = subtotal.add(BigDecimal.TEN);
        System.out.println(subtotal);

        //comparing
        subtotal = BigDecimal.ONE;
        System.out.println(subtotal.equals(BigDecimal.ONE));
        System.out.println(subtotal.compareTo(BigDecimal.ONE));// returns 0 (equal)
        System.out.println(subtotal.compareTo(BigDecimal.TEN)); // returns -1 (less than)
        System.out.println(subtotal.compareTo(BigDecimal.ZERO)); // returns 1 (greater than)

        BigDecimal amount = BigDecimal.TEN;
        if (subtotal.compareTo(amount) > 1){

        }


    }
}

package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {

    private BigDecimal price;

    public Pig() {
        super("Pig", "oink!");
        price = new BigDecimal("250.00");
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String eat() {
        return "Eating pig food";
    }

}

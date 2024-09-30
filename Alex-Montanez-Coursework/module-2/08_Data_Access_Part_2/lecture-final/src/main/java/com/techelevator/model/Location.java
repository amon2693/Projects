package com.techelevator.model;

public class Location {

    private String description;
    private boolean wheelchairAccessible;
    private boolean kidFriendly;
    private boolean publicRestroom;
    private double cost;
    private String address;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public boolean isKidFriendly() {
        return kidFriendly;
    }

    public void setKidFriendly(boolean kidFriendly) {
        this.kidFriendly = kidFriendly;
    }

    public boolean isPublicRestroom() {
        return publicRestroom;
    }

    public void setPublicRestroom(boolean publicRestroom) {
        this.publicRestroom = publicRestroom;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

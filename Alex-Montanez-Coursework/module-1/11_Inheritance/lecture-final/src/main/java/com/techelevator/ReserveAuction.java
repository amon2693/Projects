package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return  isCurrentWinningBid;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    @Override
    public String toString() {
        return "Auction of '" + getItemForSale() + "' with reserve price of " + getReservePrice() + ".";
    }

}

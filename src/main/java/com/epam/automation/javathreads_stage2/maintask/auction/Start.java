package com.epam.automation.javathreads_stage2.maintask.auction;

public class Start {
    public static void main(String[] args) {
        Auction auction = new Auction();
        auction.registerAuction(10);
        auction.startAuction(1, "Gold", 1500);
        auction.startAuction(2, "Silver", 500);
        auction.startAuction(3, "Bronze", 100);
    }
}

package com.epam.automation.JavaThreads.MainTask.Auctions;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Auction auction = new Auction();
        auction.registerAuction(5);
        auction.startAuction(1, "Gold", 1500);
        auction.startAuction(2, "Silver", 1100);
        auction.startAuction(3, "Bronze", 1400);
    }
}

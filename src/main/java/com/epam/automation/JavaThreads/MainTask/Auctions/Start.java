package com.epam.automation.JavaThreads.MainTask.Auctions;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Auction auction = new Auction();
        auction.registerAuction(5);
        auction.startAuction("Gold",1000);
    }
}

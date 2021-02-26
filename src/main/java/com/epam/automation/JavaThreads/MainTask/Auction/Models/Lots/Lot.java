package com.epam.automation.JavaThreads.MainTask.Auction.Models.Lots;

public class Lot {
    private int id;
    private String lotName;
    private int currentPrice;

    public Lot(int id, String lotName, int currentPrice) {
        this.id = id;
        this.lotName = lotName;
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}

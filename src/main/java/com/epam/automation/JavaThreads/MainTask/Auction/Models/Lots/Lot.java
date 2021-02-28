package com.epam.automation.JavaThreads.MainTask.Auction.Models.Lots;

public class Lot {
    private int id;
    private String name;
    private int currentPrice;

    public Lot(int id, String name, int currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}

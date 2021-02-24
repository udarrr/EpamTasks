package com.epam.automation.JavaThreads.MainTask.Auctions;

public class Lots {
    String lotName;
    int currentPrice;

    public Lots(String lotName, int currentPrice) {
        this.lotName = lotName;
        this.currentPrice = currentPrice;
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

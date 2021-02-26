package com.epam.automation.JavaThreads.MainTask.Auction.Console;

public class Printer {
    public void payWinnerOfLot(int idPotentialWinner, int currentPriceLot, int cashAfterPay) {
        System.out.println("\033[0;32m" + "Winner participant with id=" + idPotentialWinner + "\u0020" +
                "Lot with price: " + currentPriceLot + "\u0020" + "Current cash after pay=" + cashAfterPay + "\033[0;38m");
    }

    public void printWinnerWithoutCash(int idPotentialWinner, int currentCashPotentialWinner, int currentPriceLot) {
        System.err.println("\033[0;31m" + "Participant id=" + idPotentialWinner + "\u0020" +
                "don't have enough money, he has got " + currentCashPotentialWinner + "\u0020" +
                "necessary"+ "\u0020" + currentPriceLot + "\033[0;38m");
        System.out.println();
    }

    public void printAuctionWithoutParticipant() {
        System.err.println("Auction did not take place");
    }

    public void printAuctionWithoutResult() {
        System.out.println("\033[0;33m" + "Winner isn't determine" + "\033[0;38m");
    }

    public void printBetOfParticipant(String participant, int currentPrice) {
        System.out.println(participant + "\u0020" + "Bet =" + currentPrice);
    }

    public void printRefuseOfParticipant(String participant) {
        System.out.println(participant + "\u0020" + "Refused");
    }

    public void printBetPotentialWinner(String participant, int currentPrice) {
        System.out.println(participant + "\u0020" + "Potential winner with bet=" + currentPrice);
    }

    public void printFeeRounds(String participant, int feeRounds) {
        System.out.println(participant + "\u0020" + "have fee quantity lots=" + feeRounds);
    }

    public void printWaitingParticipant(String participant) {
        System.out.println(participant + "\u0020" + "Waiting new lot");
    }
}

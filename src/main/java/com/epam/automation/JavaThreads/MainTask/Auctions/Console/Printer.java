package com.epam.automation.JavaThreads.MainTask.Auctions.Console;

public class Printer {
    public void payWinnerForLot(int idPotentialWinner,int currentPriceLot, int cashAfterPay) {
        System.out.println("\033[0;32m" + "Winner participant with id=" + idPotentialWinner +"  Lot with price: " + currentPriceLot + " Current cash after pay=" + cashAfterPay + "\033[0;38m");
    }

    public void printWinnerWithoutCash(int idPotentialWinner, int currentCashPotentialWinner, int currentPriceLot) {
        System.err.println("\033[0;31m" + "Participant id=" + idPotentialWinner + " don't have enough money he has got " + currentCashPotentialWinner + " necessary " + currentPriceLot + "\033[0;38m");
        System.out.println();
    }

    public void printAuctionWithoutParticipant() {
        System.err.println("Auction did not take place");
    }

    public void printAuctionWithoutResult() {
        System.out.println("\033[0;33m" + "Winner isn't recognized" + "\033[0;38m");
    }

    public void printBetOfParticipant(String participant, int currentPrice) {
        System.out.println(participant + " bet=" + currentPrice);
    }

    public void printRefuseOfParticipant(String participant) {
        System.out.println(participant + " Refused");
    }

    public void printBetPotentialWinner(String participant, int currentPrice) {
        System.out.println(participant + " Potential winner with bet=" + currentPrice);
    }

    public void printFeeRounds(String participant, int feeRounds) {
        System.out.println(participant + " have fee quantity lots=" + feeRounds);
    }

    public void printWaitingParticipant(String participant) {
        System.out.println(participant + " Waiting new lot");
    }
}

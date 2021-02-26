package com.epam.automation.JavaThreads.MainTask.Auctions;

import com.epam.automation.JavaThreads.MainTask.Auctions.Console.Printer;
import com.epam.automation.JavaThreads.MainTask.Auctions.Participants.Participant;

import java.util.List;

public class BarrierAction implements Runnable {
    List<Participant> participants;

    public BarrierAction(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public void run() {
        boolean potentialWinner = participants.stream().filter(x -> !x.getRefused()).count() > 1;
        boolean auctionWithoutWinner = participants.stream().allMatch(Participant::getRefused);

        if (auctionWithoutWinner) {
            new Printer().printAuctionWithoutParticipant();
        } else if (!potentialWinner) {
            int idPotentialWinner = participants.stream().
                    filter(x -> !x.getRefused()).findFirst().orElseThrow().getId();

            int idCurrentLot = participants.stream().
                    filter(x -> !x.getRefused()).findFirst().orElseThrow().getCurrentIdLot();

            int currentPriceLot = participants.stream().
                    filter(x -> !x.getRefused()).findFirst().orElseThrow().getLots().stream().
                    filter(z -> z.getId() == idCurrentLot).findFirst().orElseThrow().getCurrentPrice();

            int currentCashPotentialWinner = participants.stream().
                    filter(f -> f.getId() == idPotentialWinner).findFirst().orElseThrow().getCash();

            if (currentCashPotentialWinner < currentPriceLot) {
                setFeeForWinnerWithoutCash(idPotentialWinner, currentPriceLot, currentCashPotentialWinner);
            } else {
                payForLot(idPotentialWinner, currentPriceLot);
            }
        } else {
            new Printer().printAuctionWithoutResult();
        }
    }

    private void setFeeForWinnerWithoutCash(int idPotentialWinner, int currentPriceLot, int currentCashPotentialWinner) {
        new Printer().printWinnerWithoutCash(idPotentialWinner, currentPriceLot, currentCashPotentialWinner);

        participants.stream().filter(f -> f.getId() == idPotentialWinner).findFirst().orElseThrow().setFee(2);
    }

    private void payForLot(int idPotentialWinner, int currentPriceLot) {
        participants.stream().filter(f -> f.getId() == idPotentialWinner).forEach(x -> x.setCash(x.getCash() - currentPriceLot));

        int cashAfterPay = participants.stream().filter(f -> f.getId() == idPotentialWinner).findFirst().orElseThrow().getCash();

        new Printer().payWinnerForLot(idPotentialWinner, currentPriceLot, cashAfterPay);
    }
}

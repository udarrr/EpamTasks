package com.epam.automation.javathreads_stage2.maintask.auction.models.participants;

import com.epam.automation.javathreads_stage2.maintask.auction.console.Printer;
import com.epam.automation.javathreads_stage2.maintask.auction.models.lots.Lot;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Participant implements Runnable {
    private int id;
    private int cash;
    private int fee;
    private boolean refused;
    private boolean highPrice;
    private int currentIdLot;
    private List<Lot> lots;
    private CyclicBarrier barrier;

    public Participant(int id, int cash, int fee, boolean refused, List<Lot> lots, CyclicBarrier barrier) {
        this.id = id;
        this.cash = cash;
        this.fee = fee;
        this.refused = refused;
        this.lots = lots;
        this.barrier = barrier;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public boolean isHighPrice() {
        return highPrice;
    }

    public void setHighPrice(boolean highPrice) {
        this.highPrice = highPrice;
    }

    public int getCurrentIdLot() {
        return currentIdLot;
    }

    public void setCurrentIdLot(int currentIdLot) {
        this.currentIdLot = currentIdLot;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }

    public void addLot(Lot lot) {
        lots.add(lot);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int roundsFee) {
        this.fee = fee;
    }

    public boolean getRefused() {
        return refused;
    }

    public void setRefused(boolean refused) {
        this.refused = refused;
    }

    @Override
    public void run() {
        if (fee == 0) {

            if (!highPrice) {

                if (!refused) {
                    involveInRound();
                } else {
                    new Printer().printWaitingParticipant(toString());
                }
            } else {
                int currentPrice = lots.stream().filter(f -> f.getId() == currentIdLot).findFirst().orElseThrow(NullPointerException::new).getCurrentPrice();

                new Printer().printBetPotentialWinner(toString(), currentPrice);
            }
        } else {
            new Printer().printFeeRounds(toString(), fee);
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void involveInRound() {
        boolean involved = new Random().nextBoolean();

        if (involved) {
            int bet = new Random().nextInt(50);

            lots.stream().filter(f -> f.getId() == currentIdLot).findFirst().
                    ifPresent(z -> z.setCurrentPrice(z.getCurrentPrice() + bet));

            int currentPrice = lots.stream().
                    filter(f -> f.getId() == currentIdLot).findFirst().orElseThrow(NullPointerException::new).getCurrentPrice();

            new Printer().printBetOfParticipant(toString(), currentPrice);
        } else {
            refused = true;

            new Printer().printRefuseOfParticipant(toString());
        }
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", cash=" + cash +
                '}';
    }
}

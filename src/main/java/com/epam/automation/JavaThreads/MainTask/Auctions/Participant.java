package com.epam.automation.JavaThreads.MainTask.Auctions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Participant implements Runnable {
    private int id;
    private int cash;
    private int roundsFee;
    private boolean refused;
    private List<Lots> lots;
    private CyclicBarrier barrier;

    public Participant() {
        super();
    }

    public Participant(int id, int cash, int roundsFee, boolean refused, List<Lots> lots, CyclicBarrier barrier) {
        this.id = id;
        this.cash = cash;
        this.roundsFee = roundsFee;
        this.refused = refused;
        this.lots = lots;
        this.barrier = barrier;
    }

    public void addLot(Lots lot) {
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

    public int getRoundsFee() {
        return roundsFee;
    }

    public void setRoundsFee(int roundsFee) {
        this.roundsFee = roundsFee;
    }

    public boolean getRefused() {
        return refused;
    }

    public void setRefused(boolean refused) {
        this.refused = refused;
    }

    @Override
    public void run() {
        boolean involveInRound = new Random().nextBoolean();
        if (!refused) {
            if (involveInRound) {
                int bet = new Random().nextInt(15);
                System.out.println("Don't refused");
            } else {
                refused = true;
                System.out.println("Refused");
            }
        } else {
            System.out.println("Early refused");
        }

        try {
            barrier.await();
            Thread.sleep(1000);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

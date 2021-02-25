package com.epam.automation.JavaThreads.MainTask.Auctions;

import com.epam.automation.JavaThreads.MainTask.Auctions.Exceptions.OnlyOneParticipantException;
import com.epam.automation.JavaThreads.MainTask.Auctions.Lots.Lot;
import com.epam.automation.JavaThreads.MainTask.Auctions.Participants.Participant;

import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    List<Participant> participants =  new ArrayList<>();;
    public CyclicBarrier roundAuction;
    BarrierAction barrierAction = new BarrierAction(participants);

    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public void registerAuction(int participantsCount) {

        roundAuction = new CyclicBarrier(participantsCount, barrierAction);

        for (int i = 0; i < participantsCount; i++) {
            addParticipant(new Participant(i, 5000, 0, false, new ArrayList<>(), roundAuction));
        }
    }

    public void startRoundAuction(){
        int sizeParticipantInRound = (int) participants.stream().filter(f->!f.getRefused()).count();
        roundAuction = new CyclicBarrier(sizeParticipantInRound, barrierAction);
        participants.stream().filter(f->!f.getRefused()).forEach(x->x.setBarrier(roundAuction));
        participants.stream().filter(f->!f.getRefused()).forEach(x -> new Thread(x).start());
    }

    public void startAuction(int id, String nameLot, int currentPrice) throws InterruptedException {
        participants.forEach(x -> x.addLot(new Lot(id, nameLot, currentPrice)));
        participants.forEach(z -> z.setCurrentIdLot(id));

        checkFee();
        try {
            setStateBeforeNewLot();

            while (participants.stream().filter(x -> !x.getRefused()).count() > 1) {
                System.out.println("Lot name " + nameLot);
                //participants.forEach(x -> new Thread(x).start());
                startRoundAuction();
                Thread.sleep(3000);
                System.out.println();

                setCurrentLotWithHighBet(id);
                setCurrentBetAllParticipants(id);
            }
        } catch (OnlyOneParticipantException e) {
            System.out.println(nameLot + " " + e.getMessage());
        }
    }

    private void setCurrentLotWithHighBet(int id) {
        Lot currentLotWithHighPrice = participants.stream().flatMap(x -> x.getLots().
                stream()).filter(f -> f.getId() == id).max(Comparator.comparing(Lot::getCurrentPrice)).
                orElseThrow();

        participants.stream().filter(x -> {
            return x.getLots().stream().anyMatch(v -> v.equals(currentLotWithHighPrice));
        }).forEach(v -> v.setHighPrice(true));

        participants.stream().filter(x -> {
            return x.getLots().stream().noneMatch(v -> v.equals(currentLotWithHighPrice));
        }).forEach(v -> v.setHighPrice(false));
    }

    private void setCurrentBetAllParticipants(int id) {
        int currentBet = participants.stream().flatMap(x -> x.getLots().
                stream()).filter(f -> f.getId() == id).max(Comparator.comparing(Lot::getCurrentPrice)).
                orElseThrow().getCurrentPrice();

        participants.forEach(x -> {
            x.getLots().stream().filter(f -> f.getId() == id).forEach(z -> z.setCurrentPrice(currentBet));
        });
    }

    private void checkFee() {
        participants.forEach(x -> {
            if (x.getFee() > 0) {
                x.setFee(x.getFee() - 1);
            }
        });
    }

    private void setStateBeforeNewLot() throws OnlyOneParticipantException {
        long countParticipantWithFee = participants.stream().filter(f -> f.getFee() > 0).count();
        if (((long) participants.size() - countParticipantWithFee) < 2) {
            throw new OnlyOneParticipantException("There is only one participant");
        }
        for (Participant participant : participants) {
            if (participant.getFee() > 0) {
                participant.setRefused(true);
            } else {
                participant.setRefused(false);
            }
            participant.setHighPrice(false);
        }
    }
}

package com.epam.automation.JavaThreads.MainTask.Auctions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    List<Participant> participants;
    public CyclicBarrier roundAuction;

    public void addParticipant(Participant p){
        participants.add(p);
    }

    public void registerAuction(int participantsCount){
        participants = new ArrayList<>();
        roundAuction =new CyclicBarrier(participantsCount, new Winner(participants));

        for (int i = 0; i < participantsCount; i++) {
            addParticipant(new Participant(i,1000,0,false, new ArrayList<>(), roundAuction));
        }
    }

    public void startAuction(String nameLot, int currentPrice) throws InterruptedException {
        participants.forEach(x->x.addLot(new Lots(nameLot,currentPrice)));
        while (participants.stream().filter(x->!x.getRefused()).count() > 1) {
            participants.forEach(x -> new Thread(x).start());
            Thread.sleep(5000);
            System.out.println();
        }
    }
}

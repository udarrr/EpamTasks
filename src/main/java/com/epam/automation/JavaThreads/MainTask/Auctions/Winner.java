package com.epam.automation.JavaThreads.MainTask.Auctions;

import java.util.List;

public class Winner implements Runnable{

    List<Participant> participants;

    public Winner(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public void run() {

    }
}

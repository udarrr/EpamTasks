package com.epam.automation.JavaThreads.MainTask;

import com.epam.automation.JavaThreads.MainTask.Cars.Car;
import com.epam.automation.JavaThreads.MainTask.Resources.Resource;

import java.util.concurrent.Semaphore;

public class Start {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(Resource.NUMBER_OF_PARKING_PLACES);
        new Car(0,"2646BI",3,semaphore).start();
        new Car(1,"1111BI",3,semaphore).start();
        new Car(2,"2222BI",3,semaphore).start();
        new Car(3,"3333BI",2,semaphore).start();
        new Car(4,"2646BI",1,semaphore).start();
        new Car(5,"1111BI",3,semaphore).start();
        new Car(6,"2222BI",1,semaphore).start();
        new Car(7,"3333BI",5,semaphore).start();
    }
}

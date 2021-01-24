package com.company;

public class CreateDataAboutCars
{
public  static RegIdOfCar[] CreateMassive ()
{
    RegIdOfCar[] data = new RegIdOfCar[2];
    data[0] = new RegIdOfCar(1,"VW","POLO",2018, "Black",12000.,"5116BI-6");
    data[1] = new RegIdOfCar(2,"SCKODA","OCTAVIA",2016, "Silver",16000.,"1534BB-6");

    return data;
}

}

package com.company;

import java.util.Random;
import java.util.Scanner;

public class CreateDataAboutCars
{
    enum ModelBMW {X1,X2,X3,X4,X5,X6,X7}
    enum ModelMitsubishi {SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE}
    enum ModelVAZ {VAZ2106,VAZ2101,CROSS,VESTA,GRANTA,SEDAN}

    public enum VendorCars
    {
        VW,BMW,MITSUBISHI,VAZ;

        public static VendorCars getRandomVendorsCars() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum ModelVW
    {
        POLO,TOURAN,GOLF,PASSAT,SHARAN;

        public static ModelVW getRandomModelsVW() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

public  static RegIdOfCar[] CreateMassive ()
{
    Random rnd = new Random();

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter quantity cars from catalog: ");
    int line = sc.nextInt();

    RegIdOfCar[] data = new RegIdOfCar[line];


    for (int i = 0; i < data.length; i++)
    {
        switch (VendorCars.getRandomVendorsCars())
        {
            case VW ->  data[i] = new RegIdOfCar(i,"VW", ModelVW.getRandomModelsVW().toString(),
                    rnd.nextInt(), "Black",12000.,"5116BI-6");
            default -> System.out.println("Wrong action");
        }
    }

    return data;
}

}

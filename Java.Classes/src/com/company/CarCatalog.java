package com.company;

public class CarCatalog
{
    public enum enumVendorCars
    {
        VW,BMW,MITSUBISHI,VAZ;

        public static enumVendorCars getRandomVendorsCars()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum enumModelVW
    {
        POLO,TOURAN,GOLF,PASSAT,SHARAN;

        public static enumModelVW getRandomModelsVW()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum enumModelBMW
    {
        X1,X2,X3,X4,X5,X6,X7;

        public static enumModelBMW getRandomModelBMW()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum enumModelMitsubishi
    {
        SPACESTAR,VAGON,PADJERO,OUTLANDER,ASX,ECLIPSE;

        public static enumModelMitsubishi getRandomModelMitsubishi()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum enumModelVAZ
    {
        VESTA,GRANTA,LADA2101,LADA2106,LADASedan,CROSS;

        public static enumModelVAZ getRandomModelVAZ()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public enum enumColorCars
    {
        BLACK,WHITE,RED,GREEN,ORANGE,BLUE,BACLAGAN;

        public static enumColorCars getRandomColorOfCars()
        {
            return values()[(int) (Math.random() * values().length)];
        }
    }
}

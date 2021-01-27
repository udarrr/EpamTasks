package Enums;

public enum CarColors
{
        BLACK,WHITE,RED,GREEN,ORANGE,BLUE,BACLAGAN;

        public static CarColors getRandomCarColors()
        {
            return values()[(int) (Math.random() * values().length)];
        }
}

package Enums;

public enum CarColor
{
        BLACK,WHITE,RED,GREEN,ORANGE,BLUE,BACLAGAN;

        public static CarColor getRandomColor()
        {
            return values()[(int) (Math.random() * values().length)];
        }

    public boolean equalsIgnoreCase(String request)
    {
        return CarColor.getRandomColor().name().equals(request);
    }
}

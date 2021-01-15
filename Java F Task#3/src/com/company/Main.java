package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner res = new Scanner(System.in);
        System.out.println("Enter count of number");
        String randomNumber = res.nextLine();
        System.out.println("Numbers of count: "+ randomNumber);
        Random ran = new Random();

        int count = Integer.parseInt(randomNumber);
        int[] countarray = new int[count];
          for(int i=0;i<count;i++)
          {
              int temp = ran.nextInt(10);

            System.out.println(temp+" ");
            countarray[i] = temp;

          }
          String result = Arrays.toString(countarray);
          System.out.println(result);
    }
}

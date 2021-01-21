package com.company;

import java.util.Random;
import java.util.Scanner;

public class CreateNewMassive {

int[][] arr(){
    int n = 0;
    Random count = new Random();

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i <arr.length ; i++) {
        for (int j = 0; j < arr[i].length; j++) {

            arr[i][j] = count.nextInt(2);
        }
    }
    return arr;
}
}

package com.epam.automation.JavaIO;

import com.epam.automation.JavaIO.Console.Menu;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        new Menu().readPathOrFile();
    }
}

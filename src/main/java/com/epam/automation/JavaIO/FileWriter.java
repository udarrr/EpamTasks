package com.epam.automation.JavaIO;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {


    public void writeLinesToFile(String[] strings) throws IOException {

        BufferedWriter out = new BufferedWriter(
        new java.io.FileWriter("src\\main\\java\\com\\epam\\automation\\JavaIO\\File\\file.txt"));

        for (int i = 0; i < strings.length; i++) {
            out.write(strings[i] + "\r\n");
        }
        out.close();
    }
}

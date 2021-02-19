package com.epam.automation.JavaIO;

import com.epam.automation.JavaIO.Resources.PathPlaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void putLinesToFile(String strings) throws IOException {
        BufferedWriter out = new BufferedWriter(
        new FileWriter(PathPlaces.getPlaceAfterReadingDirectories()));

        out.write(strings);
        out.close();
    }
}

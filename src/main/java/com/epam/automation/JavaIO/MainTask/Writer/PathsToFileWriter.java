package com.epam.automation.JavaIO.MainTask.Writer;

import com.epam.automation.JavaIO.MainTask.Resources.PathPlaces;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PathsToFileWriter {
    public void putLinesToFile(String text) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PathPlaces.getPlaceAfterReadingDirectories()))) {
            out.write(text);
        }
    }
}

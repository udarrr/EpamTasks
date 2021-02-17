package com.epam.automation.JavaIO;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Start {
    public static void main(String[] args) throws IOException {
        PathReader pathReader = new PathReader();
        List<Path> paths = pathReader.getPaths();

    }
}

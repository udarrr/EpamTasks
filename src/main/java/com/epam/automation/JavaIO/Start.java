package com.epam.automation.JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Start {
    public static void main(String[] args) throws IOException {
         PathReader pathReader = new PathReader();
         List<Path> paths = pathReader.getPaths();

        File file = new File("C:\\test");
        System.out.println(ConsolePrinter.printDirectoryTree(file));
//
//        pathReader.transformLine(0,0,paths);

    }
}

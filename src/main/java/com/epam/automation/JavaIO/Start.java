package com.epam.automation.JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Start {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Play Games\\Battle.net");

        DirectoriesReader directoriesReader = new DirectoriesReader();

        List<Path> paths = directoriesReader.getPaths();

        directoriesReader.getDirectoriesTree(file);
        System.out.println(directoriesReader.getDirectoriesTree(file));
    }
}

package com.epam.automation.JavaCollections.OptionalTask;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StartPoint3 {

    public static void main(String[] args) throws IOException {
        String path = "src\\main\\java\\com\\epam\\automation\\";

        List<Path> allDirectoriesAndSubDirectories = new ArrayList<>(getAllSubDirectories(getAllDirectories(path)));

        for (Path paths : allDirectoriesAndSubDirectories) {
            System.out.println(paths);
        }
    }

    private static List<Path> getAllDirectories(String path) throws IOException {
        List<Path> pathsDirectories = new ArrayList<>();

        DirectoryStream<Path> directories = Files.newDirectoryStream(Path.of(path));

        for (Path paths : directories) {
            pathsDirectories.add(paths);
        }

        return pathsDirectories;
    }

    private static List<Path> getAllSubDirectories(List<Path> listSubDirectories) throws IOException {
        List<Path> pathsSubdirectories = new ArrayList<>();

        for (int i = 0; i < listSubDirectories.size(); i++) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(Path.of(String.valueOf(listSubDirectories.get(i))));

            for (Path recursionPaths : paths) {
                if (Files.isDirectory(recursionPaths)) {
                    pathsSubdirectories.add(recursionPaths);
                }
            }

            if (getAllSubDirectories(pathsSubdirectories).size() > 0) {
                pathsSubdirectories.addAll(getAllSubDirectories(pathsSubdirectories));
            }
        }

        return pathsSubdirectories;
    }
}

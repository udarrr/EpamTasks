package com.epam.automation.JavaIO;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathReader {

    public List<Path> getPaths() throws IOException {
        Path path = Paths.get("C:\\test");
        List<Path> paths = listFiles(path);
        paths.forEach(System.out::println);

        return paths;
    }

    private List<Path> listFiles(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {

            result = walk.collect(Collectors.toList());
        }
        return result;
    }
}

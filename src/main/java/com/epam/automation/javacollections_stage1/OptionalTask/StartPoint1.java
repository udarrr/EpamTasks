package com.epam.automation.javacollections_stage1.OptionalTask;

import java.io.*;
import java.util.*;

public class StartPoint1 {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("src\\main\\java\\com\\epam\\automation\\JavaCollections\\OptionalTask\\Files\\TaskPoint1.txt"));

            String line;

            while ((line = in.readLine()) != null) {
                queue.add(line);
            }

            in.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + " File isn't exist");
        }

        Deque<String> linesFromFileInReverseOrder = new LinkedList<>();

        while (queue.size() != 0) {
            linesFromFileInReverseOrder.addFirst(queue.poll());
        }

        Iterator<String> iterator = linesFromFileInReverseOrder.iterator();

        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("src\\main\\java\\com\\epam\\automation\\JavaCollections\\OptionalTask\\Files\\TaskPoint1.txt"));

            while (iterator.hasNext()) {
                out.write(iterator.next());
                out.write(System.lineSeparator());
            }

            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + " Path isn't exist");
        }
    }
}

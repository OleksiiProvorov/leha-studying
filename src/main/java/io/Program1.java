package io;

import okio.BufferedSource;
import okio.Okio;
import okio.Source;

import java.util.Scanner;
import java.io.*;

public class Program1 {
    private Scanner scanner;

    public Program1(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("txt1.json");
        System.out.println("Press enter to see your strings: ");
        while (true) {
            String choice = scanner.nextLine();
            if (choice.equals("")) {

                try {
                    Source source = Okio.source(file);
                    BufferedSource bufferedSource = Okio.buffer(source);

                    while (!bufferedSource.exhausted()) {
                        String line = bufferedSource.readUtf8Line();
                        System.out.println(line);
                    }
                } catch (IOException ex) {
                    System.out.println("loh");
                    continue;
                }
            }
            if (choice.equals("exit")) {
                return;
            }

        }
    }
}

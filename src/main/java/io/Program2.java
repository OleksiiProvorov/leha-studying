package io;

import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {
    private Scanner scanner;

    public Program2(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("file.txt");
        System.out.println("Add new string to file txt: ");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                return;
            }
            try {
                BufferedSink bufferedSink = Okio.buffer(Okio.sink(file));
                bufferedSink.writeUtf8(text);
                bufferedSink.flush();
                bufferedSink.close();


            } catch (IOException ex) {
                System.out.println("idi naxui");
            }
        }
    }
}

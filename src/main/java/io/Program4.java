package io;

import java.util.Arrays;
import java.util.Scanner;

public class Program4 {
    private Scanner scanner;

    public Program4(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {

        System.out.println("Add string");
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                return;
            }

            String[] array = text.split(";");
            System.out.println(Arrays.toString(array));
        }
    }
}

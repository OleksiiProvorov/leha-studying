package io;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program1 program1 = new Program1(scanner);
        Program2 program2 = new Program2(scanner);
        Program3 program3 = new Program3(scanner);
        Program4 program4 = new Program4(scanner);

        while (true) {
            System.out.println("1.Read file txt");
            System.out.println("2.Add strings to file txt");
            System.out.println("3.Append strings to file txt");
            System.out.println("4.Array string");
            System.out.println("5.Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                program1.process();
            } else if (choice.equals("2")) {
                program2.process();
            } else if (choice.equals("3")) {
                program3.process();
            } else if (choice.equals("4")) {
                program4.process();
            }
            else if(choice.equals("5")){
                System.out.println("Goodbye! ");
                break;
            }
        }
    }
}
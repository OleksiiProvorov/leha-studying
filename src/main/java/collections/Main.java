package collections;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Program1 program1 = new Program1(scan);
        Program2 program2 = new Program2(scan);
        Program3 program3 = new Program3(scan);
        Program4 program4 = new Program4(scan);
        Program5 program5 = new Program5(scan);
        Program6 program6 = new Program6(scan);
        Program7 program7 = new Program7(scan);


        while (true) {
            System.out.println("1. Add string or show list");
            System.out.println("2. Add user, age or search user by age");
            System.out.println("3. Add string and show list in order");
            System.out.println("4. Show list and remove string");
            System.out.println("5. Add number or show list numbers");
            System.out.println("6. Add number in reverse orders or show list numbers");
            System.out.println("7. Add User");
            System.out.println("8. Exit");

            String choice = scan.nextLine();

            if (choice.equals("1")) {
                program1.process();
            } else if (choice.equals("2")) {
                program2.process();
            } else if (choice.equals("3")) {
                program3.process();
            } else if (choice.equals("4")) {
                program4.process();
            } else if (choice.equals("5")) {
                program5.process();
            } else if (choice.equals("6")) {
                program6.process();
            } else if (choice.equals("7")) {
                program7.process();
            } else if (choice.equals("8")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
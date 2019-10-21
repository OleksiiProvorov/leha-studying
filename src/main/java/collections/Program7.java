package collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program7 {
    private ArrayList<User> users = new ArrayList<>();
    private Scanner scanner;

    public Program7(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("txt7.json");
        try {
            JSONArray jsonArray = (JSONArray) JSONValue.parseWithException(new FileReader(file));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                User user = new User((String) jsonObject.get("name"), (String) jsonObject.get("age"),
                        (String) jsonObject.get("height"), (String) jsonObject.get("weight"));
                users.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        while (true) {
            System.out.println("Enter name or 'show'");

            String next = scanner.nextLine();

            if (next.equals("show")) {
                System.out.println(users);
                continue;
            }
            if (next.equals("exit")) {
                JSONArray jsonArray = new JSONArray();

                for (User user : users) {
                    String text = user.toText();
                    String[] array = text.split(";");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", array[0]);
                    jsonObject.put("age", array[1]);
                    jsonObject.put("height", array[2]);
                    jsonObject.put("weight", array[3]);
                    jsonArray.add(jsonObject);
                }

                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jsonArray.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                return;
            }
            String name = next;
            System.out.println("Enter age");
            String age = scanner.nextLine();
            System.out.println("Enter height");
            String height = scanner.nextLine();
            System.out.println("Enter weight");
            String weight = scanner.nextLine();

            User user = new User(name, age, height, weight);
            users.add(user);
            user.displayInfo();
        }
    }
}

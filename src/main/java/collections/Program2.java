package collections;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Program2 {
    private Map<Integer, String> myUsers = new HashMap<>();
    private Scanner scanner;

    public Program2(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("txt2.json");
        try {
            JSONArray jsonArray = (JSONArray) JSONValue.parseWithException(new FileReader(file));
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                myUsers.put(((Long) jsonObject.get("age")).intValue(), (String) jsonObject.get("name"));
            }
            System.out.println(myUsers);
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        try {
//
//            Source source = Okio.source(file);
//            BufferedSource bufferedSource = Okio.buffer(source);
//
//            while (!bufferedSource.exhausted()) {
//                String line = bufferedSource.readUtf8Line();
//                String[] split = line.split(";");
//                int age = Integer.valueOf(split[0]);
//                String name =split[1];
//                myUsers.put(age, name);
//            }
//        } catch (IOException ex) {
//            System.out.println("loh");
//        }
        while (true) {
            System.out.println("Enter user name or type search: ");

            String next = scanner.nextLine();
            if (next.equals("")) {
                continue;
            }
            if (next.equals("search")) {
                if (myUsers == null) {
                    System.out.println("don't have users\n");
                    continue;
                }
                System.out.println("Search UserTestCase: ");
                String ageToFind = scanner.nextLine();
                int aAgeToFind = Integer.valueOf(ageToFind);
                String foundUser = myUsers.get(aAgeToFind);
                if (foundUser == null) {
                    System.out.println("don't have users with this age\n");
                    continue;
                }
                System.out.println("Name: " + foundUser + "\n" + "Age: " + aAgeToFind);
                continue;
            }
            if (next.equals("exit")) {
                JSONArray jsonArray = new JSONArray();

                for (Map.Entry<Integer, String> entry : myUsers.entrySet()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("age", entry.getKey());
                    jsonObject.put("name", entry.getValue());
                    jsonArray.add(jsonObject);
                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write(jsonArray.toJSONString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
//                try {
//                    BufferedSink bufferedSink = Okio.buffer(Okio.sink(file));
//                    for (Map.Entry<Integer, String> entry : myUsers.entrySet()) {
//                        bufferedSink.writeUtf8(entry.getKey() + ";" + entry.getValue()+"\n");
//                    }
//                    bufferedSink.flush();
//                    bufferedSink.close();
//                } catch (IOException ex) {
//                    System.out.println("loh");
//                }
                return;
            }
            System.out.println("Enter your Age: ");

            String name = next;
            String age = scanner.nextLine();
            try {
                int aAge = Integer.valueOf(age);
                myUsers.put(aAge, name);
            } catch (NumberFormatException ex) {
                System.out.println("Can't add string to age");
            }
        }
    }
}

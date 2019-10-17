package collections;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Program1 {
    private HashSet<String> items = new HashSet<>();
    private Scanner scanner;

    public Program1(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("txt1.json");
        try {
            JSONArray arrayJson = (JSONArray) JSONValue.parseWithException(new FileReader(file));
            HashSet hashSet = new HashSet(arrayJson);
            for (Object set : hashSet) {
                items.add((String) set);
            }
        } catch (Exception x) {
            System.out.println(x);
        }

//        try {
//            Source source = Okio.source(file);
//            BufferedSource bufferedSource = Okio.buffer(source);
//
//            while (!bufferedSource.exhausted()) {
//                String line = bufferedSource.readUtf8Line();
//                String[] array = line.split("\n");
//                for (String str : array) {
//                    items.add(str);
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println("loh");
//        }
        System.out.println("Input strings: ");
        while (true) {
            String name = scanner.nextLine();

            if (name.equals("exit")) {
                JSONArray jsonArray = new JSONArray();

                for (String strings : items) {
                    jsonArray.add(strings);
                }
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jsonArray.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }

//                try {
//                    BufferedSink bufferedSink = Okio.buffer(Okio.sink(file));
//                    for (String item : items) {
//                        bufferedSink.writeUtf8(item + "\n");
//                    }
//                    bufferedSink.flush();
//                    bufferedSink.close();
//                } catch (IOException ex) {
//                    System.out.println("idi naxui");
//                }
                return;
            }
            if (name.equals("")) {
                System.out.println("Append string to file");
                continue;
            }
            items.add(name);
            for (String units : items) {
                System.out.println(units);
            }
        }
    }
}

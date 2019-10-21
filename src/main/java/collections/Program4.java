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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Program4 {
    private Deque<String> dataset = new ArrayDeque<>();
    private Scanner scanner;

    public Program4(Scanner scanner) {
        this.scanner = scanner;
    }

    void process() {
        File file = new File("txt4.json");
        try {
            JSONArray arrayJson = (JSONArray) JSONValue.parseWithException(new FileReader(file));
            HashSet hashSet = new HashSet(arrayJson);
            for (Object set : hashSet) {
                dataset.addLast((String) set);
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
//                    dataset.addLast(str);
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println("loh");
//        }
        System.out.println("Input strings: ");
        while (true) {
            String next = scanner.nextLine();
            if (next.equals("")) {
                String first = dataset.pollLast();
                if (first == null) {
                    System.out.println("no more strings\n");
                    continue;
                }
                System.out.println(first);
                continue;
            }
            if (next.equals("exit")) {
                JSONArray jsonArray = new JSONArray();

                for (String data : dataset) {
                    jsonArray.add(data);
                }
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.append(jsonArray.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
//                try {
//                    BufferedSink bufferedSink = Okio.buffer(Okio.sink(file));
//                    for (String set : dataset) {
//                        bufferedSink.writeUtf8(set+"\n");
//                    }
//                    bufferedSink.flush();
//                    bufferedSink.close();
//                } catch (IOException ex) {
//                    System.out.println("loh");
//                }
                return;
            }
            dataset.addLast(next);
        }
    }
}




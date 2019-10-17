package io;


import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;

public class JsonTest {
    public static void main(String[] args) throws Exception {
        File file = new File("txt.json");
        JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(new FileReader(file));
        System.out.println(jsonObject.toString());

        System.out.println("Add name to JSON file");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Add age to JSON file");
        String age = scanner.nextLine();

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name",name);
        jsonObject1.put("age", age);
        System.out.println(jsonObject1.toString());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject1.toJSONString());
        fileWriter.close();
    }
}
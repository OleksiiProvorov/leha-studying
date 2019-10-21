package Weather;


import com.squareup.okhttp.*;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileWriter;

public class CurlTest {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?zip=94020,us&APPID=08245589258b791eda31b5552a94b461")
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        File file = new File("weather.json");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(body);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

//        System.out.println(body);

//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body1 = RequestBody.create(JSON, "{\"22\":\"lol\",\"23\":\"pol\"}");
//        Request request1 = new Request.Builder()
//                .url("https://httpbin.org/post")
//                .post(body1)
//                .build();
//        Response response1 = client.newCall(request1).execute();
//        String nameAge = response1.body().string();
//        System.out.println(nameAge);
    }
}
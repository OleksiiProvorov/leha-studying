package Weather;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WeatherAPI {
    private static final String APP_ID_QUERY_PARAM = "&APPID=08245589258b791eda31b5552a94b461";
    private static final String WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    private OkHttpClient okHttpClient;

    public WeatherAPI(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public Weather byZip(String zipCode, String countryCode) throws IOException, ParseException {
        String weatherApiUrl = WEATHER_BASE_URL + "?zip=" + zipCode + "," + countryCode + APP_ID_QUERY_PARAM;

        Request request = new Request.Builder()
                .url(weatherApiUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();

        JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(json);
        JSONObject jsonObj = (JSONObject) jsonObject.get("main");

        if (jsonObj == null) {
            return null;
        }

        return new Weather((Double) jsonObj.get("temp_min"), (Double) jsonObj.get("temp_max"));
    }
}

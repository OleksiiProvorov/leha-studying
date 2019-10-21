package Weather;

import com.squareup.okhttp.OkHttpClient;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Scanner scanner = new Scanner(System.in);
        WeatherAPI weatherAPI = new WeatherAPI(okHttpClient);

        while (true) {
            System.out.println("1. Show weather");
            System.out.println("2. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("enter city zip code: ");
                String zipCode = scanner.nextLine();
                System.out.println("enter country code: ");
                String countryCode = scanner.nextLine();

                Weather weather = null;
                try {
                    weather = weatherAPI.byZip(zipCode, countryCode);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                if (weather == null) {
                    System.out.println("Can't find weather info :(");
                    continue;
                }

                System.out.println(weather.getTempInfo());
            } else if (choice.equals("2")) {
                System.out.println("Goodbye! ");
                break;
            }
        }
    }
}

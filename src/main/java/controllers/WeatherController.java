package controllers;

import Weather.Weather;
import Weather.WeatherAPI;
import org.json.simple.parser.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)

public class WeatherController {
    private WeatherAPI weatherAPI;

    public WeatherController(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    @GET
    @Path("/byZip")
    public Response getWeather(@QueryParam("zip") String zipCode,
                               @QueryParam("country") String countryCode) {
        Weather weather = null;
        try {
            weather = weatherAPI.byZip(zipCode, countryCode);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        if (weather == null) {
            return Response.ok("Can't find weather info :(").build();
        }
        return Response.ok(weather).build();
    }
}

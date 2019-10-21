import JsonApp.NamesRepository;
import JsonApp.UsersRepository;
import Weather.WeatherAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.squareup.okhttp.OkHttpClient;
import configuration.AppConfiguration;
import controllers.JsonController;
import controllers.WeatherController;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.bson.Document;


public class App extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();
        WeatherAPI weatherAPI = new WeatherAPI(okHttpClient);
        ObjectMapper objectMapper = new ObjectMapper();

        MongoClient mongoClient = new MongoClient();
        MongoDatabase databaseNames = mongoClient.getDatabase("names");
        MongoCollection<Document> collectionNames = databaseNames.getCollection("names-database");
        NamesRepository namesRepository = new NamesRepository(collectionNames);

        MongoDatabase databaseUsers = mongoClient.getDatabase("users");
        MongoCollection<Document> collectionUsers = databaseUsers.getCollection("users-database");
        UsersRepository usersRepository = new UsersRepository(collectionUsers);

        environment.jersey().register(new WeatherController(weatherAPI));
        environment.jersey().register(new JsonController(objectMapper, namesRepository, usersRepository));
    }
}

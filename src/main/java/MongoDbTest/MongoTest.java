package MongoDbTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class MongoTest {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("user");

        MongoCollection<Document> collection = database.getCollection("mongo-user-database");
        UserRepository userRepository = new UserRepository(collection);

        MongoUser mongoUser = new MongoUser("Leha", "22");

        userRepository.insert(mongoUser);

        List<MongoUser> users = userRepository.getAll();
        for (MongoUser user : users) {
            user.displayInfo();
        }
    }
}

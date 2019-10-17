package MongoDbTest;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private MongoCollection<Document> collection;

    public UserRepository(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void insert(MongoUser mongoUser) {
        Document document = new Document().
                append("name", mongoUser.getMongoName()).
                append("age", mongoUser.getMongoAge());

        collection.insertOne(document);
    }

    public List<MongoUser> getAll() {
        List<Document> list = collection.find().into(new ArrayList<>());
        List<MongoUser> mongoUsers = new ArrayList<>();

        for (Document doc : list) {
            mongoUsers.add(new MongoUser(doc.getString("name"), doc.getString("age")));
        }
        return mongoUsers;
    }

}

package JsonApp;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private MongoCollection<Document> collection;

    public UsersRepository(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void insert(JsonUser users) {
        Document document = new Document().
                append("name", users.getName()).
                append("age", users.getAge());

        collection.insertOne(document);
    }

    public List<JsonUser> getAll() {
        List<Document> list = collection.find().into(new ArrayList<>());
        List<JsonUser> users = new ArrayList<>();

        for (Document doc : list) {
            String name = doc.getString("name");
            String age = doc.getString("age");

            JsonUser user = new JsonUser(name, age);

            users.add(user);
        }
        return users;
    }
    public void delete(){
        collection.drop();
    }
}

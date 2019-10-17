package JsonApp;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class NamesRepository {
    private MongoCollection<Document> collection;

    public NamesRepository(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void insert(JsonName name) {
        Document document = new Document().
                append("name", name.getName());

        collection.insertOne(document);
    }

    public List<JsonName> getAll() {
        List<Document> list = collection.find().into(new ArrayList<>());
        List<JsonName> names = new ArrayList<>();

        for (Document doc : list) {
            names.add(new JsonName(doc.getString("name")));
        }
        return names;
    }

    public void delete(){
        collection.drop();
    }
}

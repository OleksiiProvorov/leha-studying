package JsonApp;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.w3c.dom.Comment;

public class GitRepository {
    private MongoCollection<Document> collection;

    public GitRepository(MongoCollection<Document> collection){
        this.collection = collection;
    }

    public void WriteToRepository(){
    }
}

import access.MongoDbConnection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import model.Job;
import org.bson.Document;

public class Test {

  public static void main(String[] args) {

    String connection =
        "mongodb+srv://volkan:test123@cluster0.dsksp.mongodb.net/findmejob?retryWrites=true&w=majority";

    MongoDatabase database = MongoDbConnection.getInstance(connection).getDatabase("findmejob");
    ;
  }
}

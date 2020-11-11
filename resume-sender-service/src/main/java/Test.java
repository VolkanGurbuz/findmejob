import access.MongoDbConnection;
import com.mongodb.*;

import com.mongodb.client.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

public class Test {

  public static void main(String[] args) {

    Logger.getLogger("org.mongodb.driver").setLevel(Level.FINE);

    String connectionString =
        "mongodb+srv://volkan:test123@cluster0.dsksp.mongodb.net/findmejob?retryWrites=true&w=majority";

    MongoClient mongoClient = MongoDbConnection.getInstance(connectionString);
  }
}

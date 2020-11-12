package access;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

@Setter
@Getter
public class MongoDbConnection {
  private static Logger logger = Logger.getLogger(MongoDbConnection.class);
  private String connectionString;
  private static MongoDatabase mongoDatabase;

  public static MongoDatabase getInstance(String connectionString, String databaseName) {
    if (mongoDatabase == null) {
      try {
        MongoClient mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(databaseName);
      } catch (Exception e) {
        mongoDatabase = null;
        logger.error("mongoClient" + e.getMessage());
      }
    }

    return mongoDatabase;
  }
}

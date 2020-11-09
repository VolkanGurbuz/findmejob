package access;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import java.net.UnknownHostException;

@Setter
@Getter
public class MongoDbConnection {
  private static Logger logger = Logger.getLogger(MongoDbConnection.class);
  private static MongoDbConnection instance;
  private String connectionString;
  private static MongoClient mongoClient;

  public static MongoClient getInstance(String connectionString) {
    if (instance == null) {
      try {
        mongoClient = MongoClients.create(connectionString);
      } catch (Exception e) {
        mongoClient = null;
        logger.error("mongoClient" + e.getMessage());
      }
    }

    return mongoClient;
  }
}

import com.mongodb.client.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import services.JobService;
import services.JobServiceImpl;
import util.UtilMail;

import javax.mail.*;

public class Test {

  public static void main(String[] args) throws IOException, MessagingException {

    Logger.getLogger("org.mongodb.driver").setLevel(Level.FINE);
    Properties properties = new Properties();
    properties.load(new FileInputStream("resume-sender-service/src/main/resources/app.properties"));
    String connectionString = properties.getProperty("mongodb.uri");

    String databaseName = properties.getProperty("mongodb.database");
    ;

    JobService jobService = new JobServiceImpl();

    MongoCollection<Document> documentMongoCollection =
        jobService.listOfJobs(connectionString, databaseName);

    Properties prop = UtilMail.getProperties();
    Session session = UtilMail.getSession(prop, "", "");

    UtilMail.sendmail(session, "");
  }
}

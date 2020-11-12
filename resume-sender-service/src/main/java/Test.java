import access.MongoDbConnection;
import com.mongodb.*;

import com.mongodb.client.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import services.JobService;
import services.JobServiceImpl;
import util.UtilMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Test {

  public static void main(String[] args) throws IOException, MessagingException {

    /* Logger.getLogger("org.mongodb.driver").setLevel(Level.FINE);
    Properties properties = new Properties();
    properties.load(new FileInputStream("resume-sender-service/src/main/resources/app.properties"));
    String connectionString = properties.getProperty("mongodb.uri");

    String databaseName = "findmejob";

    JobService jobService = new JobServiceImpl();

    MongoCollection<Document> documentMongoCollection =
        jobService.listOfJobs(connectionString, databaseName);*/
    Properties prop = new Properties();
    prop.put("mail.smtp.auth", true);
    prop.put("mail.smtp.starttls.enable", true);
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.port", "25");
    Session session = UtilMail.getSession(prop, "", "");

    System.out.println("session " + session.toString());

    UtilMail.sendmail(session);
  }
}

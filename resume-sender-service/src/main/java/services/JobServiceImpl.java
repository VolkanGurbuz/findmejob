package services;

import access.MongoDbConnection;
import com.mongodb.client.MongoCollection;
import lombok.SneakyThrows;
import model.Email;
import model.Job;
import org.bson.Document;
import util.Util;

import java.util.*;

public class JobServiceImpl implements JobService {

  @SneakyThrows
  @Override
  public MongoCollection<Document> listOfJobs(String conn, String databaseName) {
    return MongoDbConnection.getInstance(conn, databaseName).getCollection("job");
  }

  @SneakyThrows
  @Override
  public Set<Email> getEmails(MongoCollection<Document> documentMongoCollection) {

    List<Job> jobList =
        documentMongoCollection.find(new Document(), Job.class).into(new ArrayList<>());
    Set<Email> emails = new HashSet<>();
    jobList.forEach(job -> emails.add(Util.getMailList(job.getDescription())));
    return emails;
  }
}

package services;

import com.mongodb.client.MongoCollection;
import model.Email;
import model.Job;
import org.bson.Document;

import java.util.List;
import java.util.Set;

public interface JobService {

  MongoCollection<Document> listOfJobs(String conn, String databaseName);

  Set<Email> getEmails(MongoCollection<Document> documentMongoCollection);
}

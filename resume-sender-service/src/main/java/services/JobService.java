package services;

import com.mongodb.client.MongoCollection;
import model.Job;
import org.bson.Document;

import java.util.List;

public interface JobService {

  MongoCollection<Document> listOfJobs(String conn, String databaseName);
}

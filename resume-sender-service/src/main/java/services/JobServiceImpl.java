package services;

import access.MongoDbConnection;
import com.mongodb.client.MongoCollection;
import model.Job;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class JobServiceImpl implements JobService {
  private Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

  @Override
  public MongoCollection<Document> listOfJobs(String conn, String databaseName) {
    return MongoDbConnection.getInstance(conn, databaseName).getCollection("job");
  }
}

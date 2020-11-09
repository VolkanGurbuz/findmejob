package services;

import model.Job;

import java.util.List;

public interface JobService {
  List<Job> listOfJobs(String parameter);
}

package com.volkangurbuz.findmejob.services;

import com.volkangurbuz.findmejob.domain.Job;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface JobService {

  List<Job> listOfJobs(String parameter) throws IOException;
}

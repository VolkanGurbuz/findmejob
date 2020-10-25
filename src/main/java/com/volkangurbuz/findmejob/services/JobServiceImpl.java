package com.volkangurbuz.findmejob.services;

import com.volkangurbuz.findmejob.domain.Job;
import com.volkangurbuz.findmejob.domain.JobDao;
import com.volkangurbuz.findmejob.utilities.Source;
import com.volkangurbuz.findmejob.utilities.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService {
  private Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
  private final JobDao jobDao = new JobDao();

  @Override
  public List<Job> listOfJobs(String parameter) throws IOException {
    String endPointUrl = String.format(Source.SEARCH_URL, parameter);
    String result = Util.sendGetRequest(endPointUrl);

    List<Job> jobList = jobDao.load(result);

    return jobList;
  }
}

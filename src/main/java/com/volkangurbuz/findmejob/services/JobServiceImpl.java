package com.volkangurbuz.findmejob.services;

import com.volkangurbuz.findmejob.domain.Job;
import com.volkangurbuz.findmejob.domain.JobDao;
import com.volkangurbuz.findmejob.domain.Skill;
import com.volkangurbuz.findmejob.repositories.JobRepository;
import com.volkangurbuz.findmejob.utilities.Source;
import com.volkangurbuz.findmejob.utilities.Util;
import com.volkangurbuz.findmejob.utilities.result.ErrorResult;
import com.volkangurbuz.findmejob.utilities.result.Result;
import com.volkangurbuz.findmejob.utilities.result.SuccessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
  private Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
  private final JobDao jobDao = new JobDao();

  private final JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public List<Job> listOfJobs(String parameter) {
    try {
      String endPointUrl = String.format(Source.SEARCH_URL, parameter);
      String result = Util.sendGetRequest(endPointUrl);
      return jobDao.load(result);
    } catch (Exception e) {
      logger.error("listOfJobs" + e.toString());
      return null;
    }
  }

  @Override
  public Result addJob(Skill skill) throws IOException {

    List<Job> jobList = listOfJobs(skill.getSkillName());

    if (!jobList.isEmpty()) {
      jobRepository.saveAll(jobList);
      return new SuccessResult(true, "jobs added by skill");
    } else return new ErrorResult(false, "Job did not find.");
  }
}

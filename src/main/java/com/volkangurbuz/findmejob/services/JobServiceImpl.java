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

import java.util.ArrayList;
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

      List<Job> jobList = new ArrayList<>();
      int pageIndex = 1;

      while (true) {
        String endPointUrl = String.format(Source.SEARCH_URL, parameter, pageIndex);
        String result = Util.sendGetRequest(endPointUrl);

        if (result.equals("[]")) {
          logger.info("empty");
          break;
        }
        pageIndex++;
        jobList.addAll(jobDao.load(result));
      }

      return jobList;
    } catch (Exception e) {
      logger.error(String.format("listOfJobs %s", e));
      return new ArrayList<>();
    }
  }

  @Override
  public Result addJob(Skill skill) {
    List<Job> jobList = listOfJobs(skill.getSkillName());
    if (!jobList.isEmpty()) {
      jobRepository.saveAll(jobList);
      return new SuccessResult(true, "jobs added by skill");
    } else return new ErrorResult(false, "Job did not find.");
  }
}

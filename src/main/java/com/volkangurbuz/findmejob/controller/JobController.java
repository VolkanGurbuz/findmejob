package com.volkangurbuz.findmejob.controller;

import com.volkangurbuz.findmejob.domain.Job;
import com.volkangurbuz.findmejob.services.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

  private Logger logger = LoggerFactory.getLogger(JobController.class);

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(value = "/jobs", method = RequestMethod.GET)
  public List<Job> getJobs(@RequestParam(name = "skillname") String skillName) throws IOException {

    return jobService.listOfJobs(skillName);
  }
}

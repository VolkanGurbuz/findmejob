package com.volkangurbuz.findmejob.controller;

import com.volkangurbuz.findmejob.domain.Job;
import com.volkangurbuz.findmejob.domain.Skill;
import com.volkangurbuz.findmejob.services.JobService;
import com.volkangurbuz.findmejob.utilities.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(value = "/jobs", method = RequestMethod.GET)
  public List<Job> getJobs(@RequestParam(name = "skillname") String skillName) throws IOException {

    return jobService.listOfJobs(skillName);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(value = "/addjob", method = RequestMethod.GET)
  public Result addJobBySkill(@RequestBody Skill skill) throws IOException {

    return jobService.addJob(skill);
  }
}

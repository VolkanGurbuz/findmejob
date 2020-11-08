package com.volkangurbuz.findmejob.services;

import com.volkangurbuz.findmejob.domain.Job;
import com.volkangurbuz.findmejob.domain.Skill;
import com.volkangurbuz.findmejob.utilities.result.Result;

import java.io.IOException;
import java.util.List;

public interface JobService {

  List<Job> listOfJobs(String parameter) throws IOException;

  Result addJob(Skill skill) throws IOException;
}

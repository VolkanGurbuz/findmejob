package com.volkangurbuz.findmejob.services;

import com.volkangurbuz.findmejob.domain.Job;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface JobService {

  List<Job> listOfJobs(String parameter) throws IOException;
}

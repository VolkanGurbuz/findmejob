package com.volkangurbuz.findmejob;

import com.volkangurbuz.findmejob.services.JobServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FindMeJobApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(FindMeJobApplication.class, args);

    JobServiceImpl jobService = new JobServiceImpl();

    jobService.listOfJobs("java");
  }
}

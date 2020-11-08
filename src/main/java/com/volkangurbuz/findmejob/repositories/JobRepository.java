package com.volkangurbuz.findmejob.repositories;

import com.volkangurbuz.findmejob.domain.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {}

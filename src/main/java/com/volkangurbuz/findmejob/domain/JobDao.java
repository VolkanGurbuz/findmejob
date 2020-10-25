package com.volkangurbuz.findmejob.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JobDao {
  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Job> load(String result) throws IOException {
    return objectMapper.readValue(result, new TypeReference<>() {});
  }
}

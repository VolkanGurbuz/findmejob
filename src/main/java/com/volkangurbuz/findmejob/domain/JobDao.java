package com.volkangurbuz.findmejob.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JobDao {
  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Job> load(String filePath) throws IOException {
    return Arrays.asList(
        objectMapper.readValue(this.getClass().getResourceAsStream(filePath), Job[].class));
  }
}

package com.volkangurbuz.findmejob.domain;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "job")
public class Job {

  @BsonId public String id;
  public String type;
  public String url;
  public String created_at;
  public String company;
  public String company_url;
  public String location;
  public String title;
  public String description;
  public String how_to_apply;
  public String company_logo;
}

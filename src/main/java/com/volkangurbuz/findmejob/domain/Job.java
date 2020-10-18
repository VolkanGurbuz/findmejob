package com.volkangurbuz.findmejob.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
  public String id;
  public String type;
  public String url;
  public String createdAt;
  public String company;
  public String companyUrl;
  public String location;
  public String title;
  public String description;
  public String howToApply;
  public String companyLogo;
}

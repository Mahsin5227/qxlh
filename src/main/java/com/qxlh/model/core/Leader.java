package com.qxlh.model.core;


public class Leader {

  private long id;
  private String name;
  private String duty;
  private String description;
  private long universityId;
  private long collegeId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDuty() {
    return duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getUniversityId() {
    return universityId;
  }

  public void setUniversityId(long universityId) {
    this.universityId = universityId;
  }


  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }

}

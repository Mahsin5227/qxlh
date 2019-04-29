package com.qxlh.model.core;


import java.util.List;

public class University {

  private long id;
  private String name;
  private String introduce;
  private String icon;
  private java.sql.Timestamp createTime;
  private String type;
  private String site;
  private String history;
  private String zhangcheng;
  private String leader;
  private List<Leader> leaders;


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


  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }


  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }


  public String getZhangcheng() {
    return zhangcheng;
  }

  public void setZhangcheng(String zhangcheng) {
    this.zhangcheng = zhangcheng;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public List<Leader> getLeaders() {
    return leaders;
  }

  public void setLeaders(List<Leader> leaders) {
    this.leaders = leaders;
  }
}

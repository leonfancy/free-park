package org.chenliang.freepark.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name = "members")
public class Member {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  private String userId;
  private String openId;
  private String memType;
  private String mobile;

  @ManyToOne
  private Tenant tenant;

  @Temporal(TemporalType.DATE)
  private Date lastPaidAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;
}

package org.chenliang.freepark.model;

import lombok.Data;

@Data
public class LoginRequest {
  private String email;
  private String password;
}

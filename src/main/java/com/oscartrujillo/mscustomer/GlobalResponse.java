package com.oscartrujillo.mscustomer;

import lombok.Data;

@Data
public class GlobalResponse<T> {
  private int code;
  private boolean success;
  private String message;
  private T data;

  public GlobalResponse(int code, boolean success, String message, T data) {
    this.code = code;
    this.success = success;
    this.message = message;
    this.data = data;
  }
}
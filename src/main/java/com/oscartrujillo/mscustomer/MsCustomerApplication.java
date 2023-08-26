package com.oscartrujillo.mscustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class MsCustomerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsCustomerApplication.class, args);
  }

}

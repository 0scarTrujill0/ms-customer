package com.oscartrujillo.mscustomer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.oscartrujillo.mscustomer.GlobalResponse;
import com.oscartrujillo.mscustomer.dto.FindCustomerDTO;
import com.oscartrujillo.mscustomer.model.CustomerResponse;

@Service
public class CustomerService {

  private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

  @Value("${myapp.defaultDocumentNumber}")
  private String defaultDocumentNumber;

  public GlobalResponse<CustomerResponse> findCustomer(FindCustomerDTO request) {
    logger.info("CustomerService: Searching for customer with document number: {}", request.getDocumentNumber());

    if (request.getDocumentNumber().equals(defaultDocumentNumber)) {
      logger.info("CustomerService: Customer found.");
      CustomerResponse customer = new CustomerResponse();
      return new GlobalResponse<>(HttpStatus.OK.value(), true, "Customer found", customer);
    } else {
      logger.info("CustomerService: Customer not found.");
      String errorMessage = "Customer not found";
      return new GlobalResponse<>(HttpStatus.NOT_FOUND.value(), false, errorMessage, null);
    }
  }
}

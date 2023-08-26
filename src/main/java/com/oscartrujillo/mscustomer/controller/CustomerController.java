package com.oscartrujillo.mscustomer.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.oscartrujillo.mscustomer.GlobalResponse;
import com.oscartrujillo.mscustomer.dto.FindCustomerDTO;
import com.oscartrujillo.mscustomer.model.CustomerResponse;
import com.oscartrujillo.mscustomer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ms-customer")
public class CustomerController {

  private final CustomerService customerService;

  private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public ResponseEntity<GlobalResponse<CustomerResponse>> findCustomer(
      @Valid @RequestBody FindCustomerDTO body,
      BindingResult bindingResult) {

    logger.info("Received request to find customer.");

    if (bindingResult.hasErrors()) {
      List<String> errorMessages = bindingResult.getFieldErrors().stream()
          .map(FieldError::getDefaultMessage)
          .collect(Collectors.toList());

      String errorMessage = String.join(", ", errorMessages);
      logger.warn("Validation error: {}", errorMessage);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new GlobalResponse<>(HttpStatus.BAD_REQUEST.value(), false, errorMessage, null));
    }

    logger.info("Calling CustomerService to find customer.");
    GlobalResponse<CustomerResponse> response = customerService.findCustomer(body);

    logger.info("Returning response.");
    return ResponseEntity.status(response.getCode()).body(response);
  }
}
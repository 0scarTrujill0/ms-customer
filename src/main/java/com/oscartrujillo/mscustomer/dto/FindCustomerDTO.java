package com.oscartrujillo.mscustomer.dto;

import lombok.Data;
import com.oscartrujillo.mscustomer.model.DocumentTypeEnum;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class FindCustomerDTO {

  @NotNull(message = "The document type is required")
  private DocumentTypeEnum documentType;

  @NotNull(message = "The document number is required")
  @Size(min = 8, max = 12, message = "The document number must be between 8 and 12 characters")
  private String documentNumber;
}

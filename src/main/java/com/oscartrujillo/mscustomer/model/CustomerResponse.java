package com.oscartrujillo.mscustomer.model;

import lombok.Data;

@Data
public class CustomerResponse {
    private String firstName = "John";
    private String secondName = "Doe";
    private String lastName = "Smith";
    private String secondLastName = "Doe";
    private String phone = "1234567890";
    private String address = "Calle 123 Carrera 456";
    private String cityOfResidence = "Medellín";
}
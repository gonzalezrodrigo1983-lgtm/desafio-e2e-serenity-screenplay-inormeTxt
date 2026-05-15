package com.bancaecuador.e2e.models;

import java.util.List;

public class PurchaseProfile {
    private String username;
    private String password;
    private List<String> products;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String expectedConfirmation;
    private String expectedError;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<String> getProducts() { return products; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPostalCode() { return postalCode; }
    public String getExpectedConfirmation() { return expectedConfirmation; }
    public String getExpectedError() { return expectedError; }
}

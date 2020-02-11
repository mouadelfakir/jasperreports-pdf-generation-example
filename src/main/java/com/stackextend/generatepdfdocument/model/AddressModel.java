package com.stackextend.generatepdfdocument.model;

public class AddressModel {

    private String firstName;
    private String lastName;
    private String streetName;
    private String postalCode;
    private String town;
    private String country;

    public AddressModel(String firstName, String lastName, String streetName, String postalCode, String town, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.town = town;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }
}

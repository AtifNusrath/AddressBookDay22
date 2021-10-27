package com.bridgelabz;

import java.util.Objects;

public class AddressBookData {
    public String typeId;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public String city;
    public String state;
    public String zip;

    public AddressBookData( String typeId, String firstName, String lastName, String phoneNumber, String email, String city, String state, String zip) {
        this.typeId = typeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressBookData)) return false;
        AddressBookData that = (AddressBookData) o;
        return  typeId == that.typeId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip, that.zip);
    }

    @Override
    public String toString() {
        return "AddressBookData{" +
                ", typeId=" + typeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}

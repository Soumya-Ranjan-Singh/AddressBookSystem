//Encapsulated class

package com.address.book;

import java.util.Iterator;
import java.util.List;

public class ContactPerson {

    //Declaring variables for Address Book System
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    //Creating one default constructor
    public ContactPerson() {
    }

    //Creating one parameterized constructor
    public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    //Create setter methods for all instance variables.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Creating getter method for first name.
    public String getFirstName() {
        return firstName;
    }

    //Grab to a toString method
    @Override
    public String toString() {
        return "ContactPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //Printing contactDetails
    public void printContact(List<ContactPerson> list) {
        if(!list.isEmpty())
        {
            System.out.println("Contact details are below.....\n");
            Iterator it = list.iterator();
            while (it.hasNext())
            {
                System.out.println(it.next());
            }
        }
        else
            System.out.println("Contact list is empty.");
    }
}


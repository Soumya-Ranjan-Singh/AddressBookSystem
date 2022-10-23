//This program is to display Welcome to Address Book System in main class.
//Use Case 1 is to create one contact in Address Book System.
//Use Case 2 is to Add another contact in Address Book System.

package com.address.book;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystemMain {

    //Creating an arraylist.
    private static ArrayList<String> contactDetails = new ArrayList<>();

    //Default Constructor
    public AddressBookSystemMain()
    {
        System.out.println("Welcome to Address Book Program !!!");
    }

    public static void main(String[] args) {

        //Initialize Object
        AddressBookSystemMain obj = new AddressBookSystemMain();

        //Calling Encapsulated Class object
        ContactPerson a = new ContactPerson("Soumya","Singh","Jobra","Cuttack",
                "Odisha","753007","8908641811","soumyars675@gmail.com");

        //Adding another contact
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the contact details.............");
        System.out.println("Enter the first name:");
        String firstName = scan.nextLine();
        System.out.println("Enter the last name:");
        String lastName = scan.nextLine();
        System.out.println("Enter the address:");
        String address = scan.nextLine();
        System.out.println("Enter the city:");
        String city = scan.nextLine();
        System.out.println("Enter the state:");
        String state = scan.nextLine();
        System.out.println("Enter the zip code:");
        String zip = scan.nextLine();
        System.out.println("Enter the phone no:");
        String phoneNumber = scan.nextLine();
        System.out.println("Enter the email:");
        String email = scan.nextLine();
        scan.close();
        ContactPerson b = new ContactPerson(firstName, lastName, address, city, state,zip,phoneNumber,email);

        //Parsing the object to create a list
        contactDetails.add(a.toString());
        contactDetails.add(b.toString());

        //Printing contact details
        a.printContact(contactDetails);
    }
}

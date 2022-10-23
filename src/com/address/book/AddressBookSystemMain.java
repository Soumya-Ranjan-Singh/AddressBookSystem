//This program is to display Welcome to Address Book System in main class.
//Use Case 1 is to create one contact.

package com.address.book;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystemMain {

    //Default Constructor
    public AddressBookSystemMain()
    {
        System.out.println("Welcome to Address Book Program !!!");
    }

    public static void main(String[] args) {

        //Initialize Object
        AddressBookSystemMain obj = new AddressBookSystemMain();

        //Calling Encapsulated Class object
        ContactPerson addressBook = new ContactPerson("Soumya","Singh","Jobra","Cuttack",
                "Odisha","753007","8908641811","soumyars675@gmail.com");

        System.out.print("\n"+addressBook.toString());
    }
}

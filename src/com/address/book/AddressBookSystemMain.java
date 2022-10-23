//This program is to display Welcome to Address Book System in main class.
//Use Case 1 is to Create one contact in Address Book System.
//Use Case 2 is to Add another contact in Address Book System.
//Use Case 3 is to Edit existing contact in Address Book System.
//Use Case 4 is to Delete a contact in Address Book System.

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

        //Doing the operations in address book.
        Scanner scan = new Scanner(System.in);
        ContactOperations addressBook = new ContactOperations();

        boolean flag = true;

        while(flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    addressBook.addContact();
                    addressBook.printContact();
                    break;

                case 2:
                    if (addressBook.checkList() == true) {
                        System.out.println("Enter the Person First name to edit details: ");
                        String person_name = scan.next();
                        boolean b = addressBook.editContact(person_name);
                        if (b == true)
                        {
                            System.out.println("Details Updated");
                        }
                        else
                        {
                            System.out.println("Contact Not Found");
                        }
                    }
                    else
                        System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                    case 3:
                        if (addressBook.checkList() == true) {
                            System.out.println("Enter the Contact to be deleted:");
                            String firstName = scan.next();
                            boolean listDeleted = addressBook.deleteContact(firstName);
                            if (listDeleted)
                            {
                                System.out.println("Details Deleted");
                            }
                            else
                            {
                                System.out.println("Cannot be Deleted");
                            }
                        }
                        else
                            System.out.println("Nothing in the contact list.\nPlease create one");
                        break;

                case 4:
                    addressBook.printContact();
                        flag = false;
                        break;
            }
        }
        scan.close();
    }
}

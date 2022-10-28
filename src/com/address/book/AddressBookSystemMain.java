//This program is to display Welcome to Address Book System in main class.
//Use Case 1 is to Create one contact in Address Book System.
//Use Case 2 is to Add another contact in Address Book System.
//Use Case 3 is to Edit existing contact in Address Book System.
//Use Case 4 is to Delete a contact in Address Book System.
//Use Case 5 is to Add multiple persons at a time in Address Book System.

package com.address.book;

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
        addressBookOperation();
    }

    public static void addressBookOperation() {
        Scanner scan = new Scanner(System.in);
        ContactOperations addressBook = new ContactOperations();

        boolean flag = true;

        while(flag) {
            System.out.println();
            System.out.println("1.Add Contact");
            System.out.println("2.Add Multiple Contact");
            System.out.println("3.Edit Contact");
            System.out.println("4.Delete Contact");
            System.out.println("5.Show Contacts");
            System.out.println("6.Exit");
            System.out.println();
            System.out.println("Enter Choice: ");

            String option = scan.next();

            switch (option) {
                case "1":
                    addressBook.addContact();
                    break;

                case "2":
                    System.out.println("1.You want to add multiple contacts from console");
                    System.out.println("You want to add multiple contacts from the contact cards");
                    System.out.println("What you want?");
                    System.out.println("Enter your choice.");
                    int choice = scan.nextInt();
                    if (choice == 1)
                    {
                        System.out.println("Enter how many contacts you want to add at a time.");
                        int numOfContacts = scan.nextInt();
                        for (int i = 1; i <= numOfContacts; i++)
                        {
                            addressBook.addContact();
                            System.out.println(i+" Contact added successfully");
                        }
                    }
                    else if (choice == 2)
                    {
                        addressBook.sharedContactCards();
                        System.out.println("Contact cards added successfully");
                    }
                    else
                        System.out.println("Enter valid choice");
                    break;

                case "3":
                    if (addressBook.checkList())
                    {
                        boolean b = addressBook.editContact();
                        if (b == true) {
                            System.out.println("Details Updated");
                        } else {
                            System.out.println("Contact Not Found");
                        }
                    }
                    else
                        System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                case "4":
                    if (addressBook.checkList())
                    {
                        boolean listDeleted = addressBook.deleteContact();
                        if (listDeleted) {
                            System.out.println("Details Deleted");
                        } else {
                            System.out.println("Cannot be Deleted");
                        }
                    }
                    else
                    System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                case "5":
                    addressBook.printContact();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Enter a valid input.");
                    break;
            }
        }
        scan.close();
    }
}

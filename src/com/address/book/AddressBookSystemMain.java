//This program is to display Welcome to Address Book System in main class.
//Use Case 1 is to Create one contact in Address Book System.
//Use Case 2 is to Add another contact in Address Book System.
//Use Case 3 is to Edit existing contact in Address Book System.
//Use Case 4 is to Delete a contact in Address Book System.
//Use Case 5 is to Add multiple persons at a time in Address Book System.
//Use Case 6 is to Add multiple Address Book to the System but condition is that each Address Book has a unique name.
//Use Case 7 is to Ensure that no duplicate entry of the same person in a particular address book.
//Use Case 8 is to Search person in a city or state across the multiple address book.
//Use Case 9 is to Search persons by city or state.
//Use Case 10 is to View persons by city or state.
//Use Case 11 is to Sort the entries in the address book alphabetically by Person's name.
//Use Case 12 is to Sort the entries in the address book by city, state or zip.

package com.address.book;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystemMain {

    //Declaring one hashmap containing all the address book
    Map<String, ContactOperations> addressBookDictionary = new HashMap<>();

    //Default Constructor
    public AddressBookSystemMain() {
        System.out.println("Welcome to Address Book Program !!!");
    }

    Scanner scan = new Scanner(System.in);
    ContactOperations addressBook;

    //Performing some contact operation
    public void addressBookOperation() {

        boolean flag = true;

        while (flag) {
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
                    if (addressBook.check == true) {
                        System.out.println(" Contact added successfully");
                    } else {
                        System.out.println("Sorry!!! Contact can't be added");
                    }
                    break;

                case "2":
                    System.out.println("1.You want to add multiple contacts from console");
                    System.out.println("2.You want to add multiple contacts from the contact cards");
                    System.out.println("What you want?");
                    System.out.println("Enter your choice.");
                    int choice = scan.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter how many contacts you want to add at a time.");
                        int numOfContacts = scan.nextInt();
                        for (int i = 1; i <= numOfContacts; i++) {
                            addressBook.addContact();
                            if (addressBook.check == true) {
                                System.out.println(i + " Contact added successfully");
                            } else {
                                System.out.println("Sorry!!! Contact can't be added");
                                System.out.println("Please input another one");
                                i--;
                            }
                        }
                    } else if (choice == 2) {
                        addressBook.sharedContactCards();
                        System.out.println("Contact cards added successfully");
                    } else
                        System.out.println("Enter valid choice");
                    break;

                case "3":
                    if (addressBook.checkList()) {
                        boolean b = addressBook.editContact();
                        if (b == true) {
                            System.out.println("Details Updated");
                        } else {
                            System.out.println("Contact Not Found");
                        }
                    } else
                        System.out.println("Nothing in the contact list.\nPlease create one");
                    break;

                case "4":
                    if (addressBook.checkList()) {
                        boolean listDeleted = addressBook.deleteContact();
                        if (listDeleted) {
                            System.out.println("Details Deleted");
                        } else {
                            System.out.println("Cannot be Deleted");
                        }
                    } else
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
    }

    //Method to save the address book
    public void saveAddressBook(String a) {
        addressBook = new ContactOperations();
        addressBookOperation();
        System.out.println("Do you want to save this address book?");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            addressBookDictionary.put(a, addressBook);
        } else {
            System.out.println("Address book is not saved");
        }
    }

    //Method to check if that given address book name is present or in the address book dictionary
    public boolean checkBookName(String a) {
        boolean flag = true;
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            String s = entry.getKey();
            if (s.equalsIgnoreCase(a)) {
                System.out.println("This name : " + a + " is already present in Address Book Dictionary\nGive a new name");
                flag = false;
                break;
            }
        }
        return flag;
    }

    //Method to print all the address book
    public void printAddressBooks() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    //Method to search and print persons by means of city and state
    public void searchPersons() {
        System.out.println("1. Search by city name");
        System.out.println("2. Search by state name");
        System.out.println("Enter your choice by means of that you want to search");
        int choice = scan.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter city name by means of which you want to search");
                String searchCity = scan.next();
                long count = 0;
                Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, ContactOperations> entry = itr.next();
                    System.out.println(entry.getKey());
                    List<ContactPerson> list = entry.getValue().getContact().stream().filter(ContactPerson ->
                            ContactPerson.getCity().equalsIgnoreCase(searchCity)).collect(Collectors.toList());
                    long cnt = entry.getValue().getContact().stream().filter(ContactPerson ->
                            ContactPerson.getCity().equalsIgnoreCase(searchCity)).count();
                    System.out.println(list);
                    count = count + cnt;
                }
                System.out.println(count);

//                Iterator<Map.Entry<String , ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
//                while (itr.hasNext())
//                {
//                    Map.Entry<String, ContactOperations> entry = itr.next();
//                    System.out.println(entry.getKey());
//                    for (int i = 0; i < entry.getValue().getContact().size(); i++)
//                    {
//                        if (entry.getValue().getContact().get(i).getCity().equalsIgnoreCase(searchCity))
//                        {
//                            System.out.println(entry.getValue().getContact().get(i));
//                        }
//                    }
//                }
                break;
            case 2 :
                System.out.println("Enter State name by means of which you want to search");
                String searchState = scan.next();
                long count1 = 0;
                Iterator<Map.Entry<String, ContactOperations>> it = addressBookDictionary.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ContactOperations> entry = it.next();
                    System.out.println(entry.getKey());
                    List<ContactPerson> list1 = entry.getValue().getContact().stream().filter(ContactPerson ->
                            ContactPerson.getState().equalsIgnoreCase(searchState)).collect(Collectors.toList());
                    System.out.println(list1);
                    long cnt1 = entry.getValue().getContact().stream().filter(ContactPerson ->
                            ContactPerson.getCity().equalsIgnoreCase(searchState)).count();
                    count1 = count1 + cnt1;
                }
                System.out.println(count1);
                break;

            default :
                System.out.println("Wrong entry. Please try again\n");
                searchPersons();
        }
    }

    //Method to print all the address book sorting by names
    public void printBySortingNames() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            List list = entry.getValue().getContact().stream().
                    sorted(Comparator.comparing(ContactPerson::getFirstName)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    //Method to print all the address book sorting by city
    public void printBySortingCity() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            List list = entry.getValue().getContact().stream().
                    sorted(Comparator.comparing(ContactPerson::getCity)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    //Method to print all the address book sorting by state
    public void printBySortingState() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            List list = entry.getValue().getContact().stream().
                    sorted(Comparator.comparing(ContactPerson::getState)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    //Method to print all the address book sorting by zip code
    public void printBySortingZipCodes() {
        Iterator<Map.Entry<String, ContactOperations>> itr = addressBookDictionary.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, ContactOperations> entry = itr.next();
            System.out.println(entry.getKey());
            List list = entry.getValue().getContact().stream().
                    sorted(Comparator.comparing(ContactPerson::getZip)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    //Method to get Print as per user wish
    public void printMap() {
        System.out.println("Enter your choice like how do you want to see your Address Books");
        System.out.println("1. Print by means of sorting names");
        System.out.println("2. Print by means of sorting city");
        System.out.println("3. Print by means of sorting state");
        System.out.println("4. Print by means of sorting zip codes");
        int choice = scan.nextInt();
        switch (choice)
        {
            case 1 :
                System.out.println("Before sorting");
                printAddressBooks();
                System.out.println("\n"+"After sorting");
                printBySortingNames();
                break;
            case 2 :
                System.out.println("Before sorting");
                printAddressBooks();
                System.out.println("\n"+"After sorting");
                printBySortingCity();
                break;
            case 3 :
                System.out.println("Before sorting");
                printAddressBooks();
                System.out.println("\n"+"After sorting");
                printBySortingState();
                break;
            case 4 :
                System.out.println("Before sorting");
                printAddressBooks();
                System.out.println("\n"+"After sorting");
                printBySortingZipCodes();
                break;
            default :
                System.out.println("Wrong choice. Please try again");
        }
    }

    public static void main(String[] args) {

        //Initialize Object
        AddressBookSystemMain obj = new AddressBookSystemMain();

        //Now saving the address book
        System.out.println("How many address book you want to save?");
        int books = obj.scan.nextInt();
        for (int i = 1; i <= books; i++) {
            System.out.println("Give one address book name");
            String a = obj.scan.next();
            if (obj.checkBookName(a)) {
                System.out.println("For " + a);
                obj.saveAddressBook(a);
            } else
                i--;
        }

        //print all address book
        obj.printMap();

        //search persons by means of city or state in whole address books
        obj.searchPersons();

        obj.scan.close();
    }
}


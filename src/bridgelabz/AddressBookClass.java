package bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookClass {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String, AddressBook> addressBookListMap = new HashMap<>();

    public void addAddressBook(String bookName) {
        boolean flag = true;
        while (flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addressBook.readData();
                    break;

                case 2:
                     addressBook.editContactPerson();
                    break;

                case 3:
                    addressBook.deletePerson();
                    break;

                case 4:
                    flag = false;
                    break;
            }
        }
        addressBookListMap.put(bookName, addressBook);
        System.out.println("Address Book Added Successfully");
    }

    private void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    private void searchPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }

    private void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactPerson> contacts = value.personByState.entrySet().stream()
                    .filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (ContactPerson contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }

    private void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactPerson> contacts = value.personByCity.entrySet().stream()
                    .filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (ContactPerson contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Management System using Java Stream");
        AddressBookClass addressBookClass = new AddressBookClass();
        boolean flag = true;
        while (flag) {
            while (flag) {
                System.out.println("1.Add New Address Book");
                System.out.println("2.Search Contact from a city");
                System.out.println("3.Search Contact from a State");
                System.out.println("4.View contact By State Using State and Person HashMap");
                System.out.println("5.View Contact by city Using City and Person HashMap");
                System.out.println("6.Exit");

                System.out.println("Enter choice: ");
                int option = sc.nextInt();
                switch (option) {
                    case 1: {
                        System.out.println("Enter the Name of Address Book: ");
                        String addressBookName = sc.next();
                        if (addressBookClass.addressBookListMap.containsKey(addressBookName)) {
                            System.out.println("The Address book Already Exists");
                            break;
                        } else {
                            addressBookClass.addAddressBook(addressBookName);
                            break;
                        }
                    }
                    case 2:
                        System.out.println("Enter Name of City: ");
                        String CityName = sc.next();
                        addressBookClass.searchPersonByCity(CityName);
                        break;

                    case 3: {
                        System.out.println("Enter Name of State: ");
                        String StateName = sc.next();
                        addressBookClass.searchPersonByState(StateName);
                        break;
                    }

                    case 4:
                        System.out.println("Enter Name of State: ");
                        String stateName1 = sc.next();
                        addressBookClass.viewPersonByStateUsingHashmap(stateName1);
                        break;

                    case 5:
                        System.out.println("Enter Name of City: ");
                        String cityName1 = sc.next();
                        addressBookClass.viewPersonByCityUsingHashMap(cityName1);
                        break;

                    case 6:
                        flag = false;
                        break;
                }
            }

        }
    }
}

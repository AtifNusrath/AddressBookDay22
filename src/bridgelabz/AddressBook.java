package bridgelabz;

import java.util.Scanner;

public class AddressBook {
    public static ContactPerson readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Details of ContactPerson");
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter Last name: ");
        String lastName = scanner.next();
        System.out.print("Enter Address: ");
        String address = scanner.next();
        System.out.print("Enter the City: ");
        String city = scanner.next();
        System.out.print("Enter the State: ");
        String state = scanner.next();
        System.out.print("Enter the ZipCode: ");
        int zipCode = scanner.nextInt();
        System.out.print("Enter the contact number: ");
        String phoneNumber = scanner.next();

        return new ContactPerson(firstName, lastName, address, city, state, zipCode, phoneNumber);
    }

    static void menu() {
        ContactPerson contactPerson = null;
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ur choice \n 1 : Add \n 2 : Display ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    contactPerson = readData();
                    break;
                case 2:

                case 4:
                    System.out.println(contactPerson);
                    break;
                default:
                    System.out.println("Enter number from 1 to 2");
            }
        } while (choice <=2 );
    }
    public static void main(String[] args) {
        menu();
    }
}

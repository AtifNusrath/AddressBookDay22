package bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookClass {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addAddressBook(String bookName){
        AddressBookClass addBook = new AddressBookClass();
        boolean flag = true;

        while(flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    addressBook.readData();
                    addressBook.display();
                    break;

                case 2:
                    addressBook.editContactPerson();
                    addressBook.display();
                    break;

                case 3:
                    addressBook.deletePerson();
                    addressBook.display();
                    break;

                case 4:
                    flag =false;
                    break;

            }
        }
    }



    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book System");
        AddressBookClass addressBookClass = new AddressBookClass();
        boolean flag =true;
        while(flag)
        {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Exit");
            System.out.println("Enter choice: ");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = sc.next();
                    if(addressBookClass.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }else {
                        addressBookClass.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:{
                    flag = false;
                    break;
                }
            }
        }
    }
}

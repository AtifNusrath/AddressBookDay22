import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookClass {
    public static Scanner sc = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String, AddressBook> addressBookListMap = new HashMap<>();
    int count;

    public void addAddressBook(String bookName) {
        boolean flag = true;
        while (flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            System.out.println("5.Exit");
            System.out.println("Enter Choice: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addressBook.readData();
                    count++;
                    break;

                case 2:
                    addressBook.editContactPerson();
                    break;

                case 3:
                    addressBook.deletePerson();
                    break;

                case 4:
                    addressBook.display();
                    break;

                case 5:
                    flag = false;
                    break;
            }
        }
        addressBookListMap.put(bookName, addressBook);
        System.out.println("Address Book Added Successfully");
    }

    private void searchPersonByState(String stateName) {
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                AddressBook value = entry.getValue();
                System.out.println("The Address Book: " + entry.getKey());
                value.getPersonNameByState(stateName);
            }
        } else {
            System.out.println("Empty address book");
        }
    }

    private void searchPersonByCity(String cityName) {
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                AddressBook value = entry.getValue();
                System.out.println("The Address Book: " + entry.getKey());
                value.getPersonNameByCity(cityName);
            }
        } else {
            System.out.println("Empty address book");
        }
    }

    private void viewPersonByState(String stateName) {
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                AddressBook value = entry.getValue();
                ArrayList<ContactPerson> contacts = value.personByState.entrySet().stream()
                        .filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst()
                        .orElse(null);
                for (ContactPerson contact : contacts) {
                    System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
                }
            }
        } else {
            System.out.println("Empty address book");
        }
    }

    private void viewPersonByCity(String cityName) {
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                AddressBook value = entry.getValue();
                ArrayList<ContactPerson> contacts = value.personByCity.entrySet().stream()
                        .filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst()
                        .orElse(null);
                for (ContactPerson contact : contacts) {
                    System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
                }
            }
        } else {
            System.out.println("Empty address book");
        }
    }

    public void CountByState(String state) {
        int countPersonByState = 0;
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                for (int i = 0; i < (entry.getValue()).persons.size(); i++) {
                    ContactPerson contact = entry.getValue().persons.get(i);

                    if (state.equals(contact.getState())) {
                        countPersonByState++;
                    }
                }
            }
            System.out.println("Total Person Count in state " + state + ": " + count);
        } else {
            System.out.println("Empty address book");
        }
    }

    public void CountByCity(String city) {
        int countPersonInCity = 0;
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                for (int i = 0; i < (entry.getValue()).persons.size(); i++) {
                    ContactPerson d = entry.getValue().persons.get(i);

                    if (city.equals(d.getCity())) {
                        countPersonInCity++;
                    }
                }
            }
            System.out.println("Total number of people in this city " + city + ": " + countPersonInCity);
        } else {
            System.out.println("Empty address book");
        }
    }

    private void sortByName() {
        if (count > 0) {
            for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
                AddressBook value = entry.getValue();
                List<ContactPerson> sortedList = value.persons.stream().sorted(Comparator.comparing(ContactPerson::getFirstName)).collect(Collectors.toList());

                for (ContactPerson contact : sortedList) {
                    System.out.println("First Name: " + contact.getFirstName());
                    System.out.println("Last Name: " + contact.getLastName());

                }
            }
        } else {
            System.out.println("Empty address book");
        }
    }

    void sortByState() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.persons.stream()
                    .sorted(Comparator.comparing(ContactPerson::getState)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------------");
            }
        }
    }

    public void sortByCity() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.persons.stream()
                    .sorted(Comparator.comparing(ContactPerson::getCity)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------------");
            }
        }
    }

    public void sortByZipCode() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<ContactPerson> sortedList = value.persons.stream()
                    .sorted(Comparator.comparing(ContactPerson::getZipCode)).collect(Collectors.toList());

            for (ContactPerson contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
                System.out.println("-------------------------------");
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
                System.out.println("6.Count Contact By State");
                System.out.println("7.Count Contact By City");
                System.out.println("8.Sort Contact By Name");
                System.out.println("9.Sort Contact By City");
                System.out.println("10.Sort Contact By State");
                System.out.println("11.Sort Contact By ZipCode");
                System.out.println("12.Write data to file");
                System.out.println("13.Read data from file");
                System.out.println("14.Write Data in CSV file");
                System.out.println("15.Read data from CSV file");
                System.out.println("16.Write Data in the Json file");
                System.out.println("17.Read data from Json file ");
                System.out.println("18.Exit");

                System.out.println("Enter choice: ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter the Name of Address Book: ");
                        String addressBookName = sc.next();
                        if (addressBookClass.addressBookListMap.containsKey(addressBookName)) {
                            System.out.println("The Address book Already Exists");
                            break;
                        } else {
                            addressBookClass.addAddressBook(addressBookName);
                            break;
                        }

                    case 2:
                        System.out.println("Enter Name of City: ");
                        String CityName = sc.next();
                        addressBookClass.searchPersonByCity(CityName);
                        break;

                    case 3:
                        System.out.println("Enter Name of State: ");
                        String StateName = sc.next();
                        addressBookClass.searchPersonByState(StateName);
                        break;

                    case 4:
                        System.out.println("Enter Name of State: ");
                        String stateName1 = sc.next();
                        addressBookClass.viewPersonByState(stateName1);
                        break;

                    case 5:
                        System.out.println("Enter Name of City: ");
                        String cityName1 = sc.next();
                        addressBookClass.viewPersonByCity(cityName1);
                        break;

                    case 6:
                        System.out.println("Enter Name of State: ");
                        String stateName2 = sc.next();
                        addressBookClass.CountByState(stateName2);
                        break;

                    case 7:
                        System.out.println("Enter Name of City: ");
                        String cityName2 = sc.next();
                        addressBookClass.CountByCity(cityName2);
                        break;

                    case 8:
                        System.out.println("Sort Contact by name");
                        addressBookClass.sortByName();
                        break;

                    case 9:
                        System.out.println("Sort Contact by City");
                        addressBookClass.sortByCity();
                        break;

                    case 10:
                        System.out.println("Sort Contact by State");
                        addressBookClass.sortByState();
                        break;

                    case 11:
                        System.out.println("Sort Contact by ZipCode");
                        addressBookClass.sortByZipCode();
                        break;

                    case 12:
                        AddressBook.writeData();
                        break;
                    case 13:
                        AddressBook.readFileData();
                        break;
                    case 14:
                        try {
                            AddressBook.writeDataToCSV();
                        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 15:
                        try {
                            AddressBook.readDataUsingCSV();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 16:
                        try {
                            AddressBook.writeDataInJSon();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 17:
                        try {
                            AddressBook.readDataFromJson();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 18:
                        flag = false;
                        break;
                }
            }
        }
    }
}

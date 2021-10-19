package bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    static ArrayList<ContactPerson> persons = new ArrayList<>();
    public static HashMap<String, ArrayList<ContactPerson>> personByState;
    public static HashMap<String, ArrayList<ContactPerson>> personByCity;
    static Scanner scanner = new Scanner(System.in);
    static int counter;
    private static int indexOfPerson;


    public AddressBook() {
        personByCity = new HashMap<>();
        personByState = new HashMap<>();
    }

    public static ArrayList<ContactPerson> readData() {
        System.out.println("Add person details...");
        ContactPerson person = new ContactPerson();
        System.out.println("Enter person first name: ");
        person.setFirstName(scanner.next());
        String result = person.getFirstName();
        boolean flag = checkDuplicate(result);
        if (flag) {
            System.out.println("Person is already exist");
        } else {
            System.out.println("Enter person last name: ");
            person.setLastName(scanner.next());
            System.out.println("Enter mobile number: ");
            person.setPhoneNumber(scanner.next());
            System.out.println("Enter address Details: ");
            System.out.println("Enter address: ");
            person.setAddress(scanner.next());
            System.out.println("Enter city: ");
            person.setCity(scanner.next());
            System.out.println("Enter State name: ");
            person.setState(scanner.next());
            System.out.println("Enter zip: ");
            person.setZipCode(scanner.nextInt());
            person.setAddressObj(person);
            persons.add(person);
            System.out.println();
            System.out.println("Person added");
            counter++;

            if (!personByState.containsKey(person.getState())) {
                personByState.put(person.getState(), new ArrayList<ContactPerson>());
            }
            personByState.get(person.getState()).add(person);

            if (!personByCity.containsKey(person.getCity())) {
                personByCity.put(person.getCity(), new ArrayList<ContactPerson>());
            }
            personByCity.get(person.getCity()).add(person);

        }
        return persons;
    }

    public void display() {
        for (ContactPerson person2 : persons)
            System.out.println(person2);
    }


    static void editContactPerson() {
        if (counter > 0) {
            System.out.println("Enter Persons FirstName you want to edit: ");
            String searchName = scanner.next();
            indexOfPerson = 0;
            boolean isFoundPerson = false;

            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getFirstName().equals(searchName)) {
                    isFoundPerson = true;
                    indexOfPerson = i;
                    break;
                }
            }
            if (isFoundPerson) {

                System.out.print("\nEnter new address: ");
                persons.get(indexOfPerson).getAddressObj().setAddress(scanner.next());
                System.out.println("Enter new city for searchName: ");
                persons.get(indexOfPerson).getAddressObj().setCity(scanner.next());
                System.out.println("Enter new zip: ");
                persons.get(indexOfPerson).getAddressObj().setZipCode(scanner.nextInt());
                System.out.println("Enter mobile number: ");
                persons.get(indexOfPerson).setPhoneNumber(scanner.next());
                persons.get(indexOfPerson).setFirstName(searchName);
                System.out.println("Enter Last Name: ");
                persons.get(indexOfPerson).setLastName(scanner.next());
                System.out.println();
                System.out.println("Edit completed");

            } else
                System.out.println("No person found with this searchName");
        } else
            System.out.println("There is no record to edit");

    }

    public static void deletePerson() {
        if (counter > 0) {
            System.out.println("Enter Persons FirstName you want to delete: ");
            String searchName = scanner.next();
            indexOfPerson = 0;
            boolean isFoundPerson = false;

            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getFirstName().equals(searchName)) {
                    isFoundPerson = true;
                    indexOfPerson = i;
                    break;
                }
            }
            if (isFoundPerson) {
                persons.remove(indexOfPerson);
                counter--;
                System.out.println();
                System.out.println("Delete completed");
            } else
                System.out.println("No person found with this name");
        } else
            System.out.println("No records to delete");
    }


    private static boolean checkDuplicate(String fname) {
        int flag = 0;
        for (ContactPerson person1 : persons) {
            if (person1.getFirstName().equals(fname)) {
                flag = 1;
                break;
            }
        }
        return flag == 1;
    }

    public void getPersonNameByState(String State) {
        List<ContactPerson> list = persons.stream().filter(contactName -> contactName.getState().equals(State))
                .collect(Collectors.toList());
        for (ContactPerson contact : list) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
        }

    }

    public void getPersonNameByCity(String cityName) {
        List<ContactPerson> list = persons.stream().filter(contactName -> contactName.getCity().equals(cityName))
                .collect(Collectors.toList());
        for (ContactPerson contact : list) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
        }
    }

    public static void writeData() {
        StringBuffer personBuffer = new StringBuffer();
        persons.forEach(person -> {
            String personDataString = person.toString().concat("\n");
            personBuffer.append(personDataString);
        });
        try {
            Files.write(Paths.get("Data.txt"), personBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void readFileData() {
        try {
            Files.lines(new File("Data.txt").toPath()).map(String::trim).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}


package bridgelabz;

public class ContactPerson {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public String phoneNumber;

    ContactPerson(String firstName, String lastName, String address, String city, String state, int zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "personInfo [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                + city + ", state=" + state + ", zipcode=" + zipCode + ", phoneNumber=" + phoneNumber + "]";
    }

}

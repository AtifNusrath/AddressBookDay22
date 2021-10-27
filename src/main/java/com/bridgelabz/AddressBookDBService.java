package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    public Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private static AddressBookDBService addressBookDBService;

    public AddressBookDBService() {
    }

    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null) {
            addressBookDBService = new AddressBookDBService();
        }
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "Mohammed@22";
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println(connection + " connection successful");
        return connection;
    }

    public List<AddressBookData> readDate() {
        String query = "SELECT * from addressbook";
        return this.getAddressBookDataUsingDB(query);
    }

    private List<AddressBookData> getAddressBookDataUsingDB(String query) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            addressBookList = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private List<AddressBookData> getAddressBookData(ResultSet resultSet) {
        List<AddressBookData> addressBookList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String typeId = resultSet.getString("type");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("mobileNumber");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                addressBookList.add(new AddressBookData(typeId, firstName, lastName, phoneNumber, email, city, state, zip));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

}

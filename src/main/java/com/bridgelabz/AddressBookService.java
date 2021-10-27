package com.bridgelabz;

import java.util.List;

public class AddressBookService {
    private List<AddressBookData> addressBookList;

    public enum IOService {DB_IO}

    private static AddressBookDBService addressBookDBService;

    public AddressBookService() {
        addressBookDBService = AddressBookDBService.getInstance();
    }

    public List<AddressBookData> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO)) {
            this.addressBookList = addressBookDBService.readDate();
        }
        return addressBookList;
    }
}

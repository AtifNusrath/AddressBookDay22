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

    public void updateRecord(String name, String phoneNumber) throws AddressBookException {
        int result = addressBookDBService.updateAddressBookRecord(name, phoneNumber);
        if (result==0)return;
        AddressBookData  addressBookData=this.getAddressBookData(name);
        if (addressBookData!=null) addressBookData.phoneNumber=phoneNumber;
    }

    private AddressBookData getAddressBookData(String name) {
        return this.addressBookList.stream()
                .filter(addressBookData -> addressBookData.firstName.equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean checkRecordSyncWithDB(String name) {
        List<AddressBookData> addressBookData= addressBookDBService.getAddressBookData(name);
        System.out.println(addressBookData);
        boolean equals = addressBookData.get(0).equals(getAddressBookData(name));
        return equals;
    }

}

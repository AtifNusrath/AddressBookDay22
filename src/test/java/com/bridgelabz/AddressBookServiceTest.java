package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bridgelabz.AddressBookService.IOService.DB_IO;

public class AddressBookServiceTest {
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchThePeopleCount() {
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
        Assert.assertEquals(5,addressBookDataList.size());
    }

    @Test
    public void givenNewPhoneNumber_ShouldUpdateTheRecorAndSyncWithDataBase() throws AddressBookException {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        addressBookService.updateRecord("Rohit", "9856322478");
        boolean result = addressBookService.checkRecordSyncWithDB("Rohit");
        Assert.assertTrue(result);
    }
}

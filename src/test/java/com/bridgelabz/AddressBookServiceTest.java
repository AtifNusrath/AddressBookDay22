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
}

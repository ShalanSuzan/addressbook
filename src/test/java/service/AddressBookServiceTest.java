package service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AddressBookRepository;


public class AddressBookServiceTest {
@Autowired
AddressBookRepository repository;

AddressBookService addressBookService = new AddressBookService(repository);

    @Test
    public void dumme(){
        addressBookService.getAddressByName("me");
    }
}

package service;


import model.AddressBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AddressBookRepository;
import rest.AddressBookRequest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.ok;


public class AddressBookServiceTest {
    AddressBookRepository repository;
    AddressBookService addressBookService;

    @Before
    public void setup(){
        setupRepository();
        addressBookService = new AddressBookService(repository);
    }

    @After
    public void tearDown(){
        repository = null;
    }


    @Test
    public void addNewEntry(){
        AddressBookRequest request = setupAddressBookRequestMock();
        addressBookService.setAddressBook(request);
        ok();
    }

    @Test
    public void getEntry(){
        AddressBookRequest request = setupAddressBookRequestMock();
        addressBookService.setAddressBook(request);
        assertNotNull(addressBookService.getAddressByName("me").get());
        assertEquals("address", addressBookService.getAddressByName("me").get().getAddress());
    }

    private AddressBookRequest setupAddressBookRequestMock() {
        AddressBookRequest request = mock(AddressBookRequest.class);
        when(request.getAddress()).thenReturn("address");
        when(request.getName()).thenReturn("me");
        return request;
    }

    private void setupRepository() {
        repository = mock(AddressBookRepository.class);
        AddressBook addressBook = mock(AddressBook.class);
        when(addressBook.getName()).thenReturn("me");
        when(addressBook.getAddress()).thenReturn("address");
        when(repository.findAll()).thenReturn(Arrays.asList(addressBook));
    }

}

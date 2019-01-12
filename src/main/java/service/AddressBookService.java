package service;

import model.AddressBook;
import repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.AddressBookRequest;
import rest.AddressBookResponse;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AddressBookService {

    private final AddressBookRepository repository;

    @Autowired
    public AddressBookService(AddressBookRepository repository) {
        this.repository = repository;
    }

    public Optional<AddressBookResponse> getAddressByName(String name) {

        AddressBookResponse response = null;

        AddressBook addressBook = getAddressBook(name);

        if(addressBook != null){
            response = AddressBookResponse.builder()
                    .name(addressBook.getName())
                    .address(addressBook.getAddress()).build();
        }

        return Optional.ofNullable(response);

    }

    public void setAddressBook(AddressBookRequest request) {

        AddressBook addressBook = getAddressBook(request.getName());

        if(addressBook == null){
            AddressBook newAddressBook = new AddressBook();
            newAddressBook.setName(request.getName());
            newAddressBook.setAddress(request.getAddress());
            repository.save(newAddressBook);
        }else {
            addressBook.setAddress(request.getAddress());
            repository.save(addressBook);
        }
    }

    private AddressBook getAddressBook(String name) {

        Set<AddressBook> addresses = repository.findAll().stream().filter(addressBook ->
                addressBook.getName().equals(name)).collect(Collectors.toSet());

        return addresses.iterator().hasNext() ? addresses.iterator().next() : null;
    }
}

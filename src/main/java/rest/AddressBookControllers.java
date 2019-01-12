package rest;

import lombok.extern.slf4j.Slf4j;
import model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AddressBookService;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Slf4j
@RestController
public class AddressBookControllers {

    @Autowired
    private final AddressBookService service;

    public AddressBookControllers(AddressBookService service) {
        this.service = service;
    }


    @GetMapping(path = "/addressbooks/{name}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AddressBookResponse> getAddressByName(@PathVariable String name){

        Optional<AddressBookResponse> person = service.getAddressByName(name);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/addressbooks", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AddressBook> insUpAddress(@RequestBody AddressBookRequest addressBookRequest){

        try {
            service.setAddressBook(addressBookRequest);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            log.error("Unexpected error occurred. Unable to add a new entry");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

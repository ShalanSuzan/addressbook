package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "AddressBook")
public class AddressBook {

    @Id
    @GeneratedValue
    long identifier;

    String name;

    String address;

}

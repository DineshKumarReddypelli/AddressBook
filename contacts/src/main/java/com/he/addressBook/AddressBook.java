package com.he.addressBook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook {
	
	List<Contact> contacts = new ArrayList<Contact>();
	
    public AddressBook() {
        //TODO
    }

	public void addContact(Contact contact) throws Exception {
		Optional<Contact> findFirst = contacts.stream().filter(c -> c.getName().equalsIgnoreCase(contact.getOrganisation()))
				.findFirst();
		if (findFirst.isPresent()) {
			throw new Exception("Duplicates found");
		}
		else {
			contacts.add(contact);
		}
	}

    @SuppressWarnings("unlikely-arg-type")
	public void deleteContact(String name) throws Exception {
    	Optional<Contact> findAny = contacts.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findAny();
    	if(findAny.isPresent())
    		contacts.remove(name);
    	else
    		throw new Exception("deleting a contact");
    }

    public void updateContact(String name, Contact contact) {
    	Contact updateContact = contacts.stream().filter(c -> c.getName().equalsIgnoreCase(contact.getName())).findAny().get();
    	updateContact.setName(name);
    }

    @SuppressWarnings("null")
	public List<Contact> searchByName(String name) {
    	List<Contact> contactList = null;
    	if(name.isEmpty()) {
    		return contactList;
    	} else {
    		contactList.stream().filter(c -> c.getName().contains(name)).collect(Collectors.toList());
            return contacts;
    	}
    }

    public List<Contact> searchByOrganisation(String organisation) {
    	if(organisation.isEmpty()) {
    		return contacts;
    	} else {
        	contacts.stream().filter(c -> c.getOrganisation().contains(organisation)).collect(Collectors.toList());
            return contacts;
    	}
    }

}
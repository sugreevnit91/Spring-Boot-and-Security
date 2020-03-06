package com.arun.phonebook.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneBookController {
	
	@Autowired
	private PhoneBookService phoneBookService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addContact")
	public void addContact(@RequestBody Contact contact) {
		phoneBookService.addContact(contact);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/editContact")
	public void editContact(@RequestBody Contact contact) {
		phoneBookService.editContact(contact);
	}
	
	@RequestMapping("/getAllContacts")
	public List<Contact> getAllContacts(){
		return phoneBookService.getAllContacts();
	}
	
	@RequestMapping("/getContactByName/{name}")
	public Contact getContactByName(@PathVariable String name) {
		return phoneBookService.getContactByName(name);
	}
	
	@RequestMapping("/getContactByNumber/{number}")
	public Contact getContactByNumber(@PathVariable String number) {
		return phoneBookService.getContactByNumber(number);
	}
	
	@RequestMapping("/deleteContact/{number}")
	public void deleteContact(@PathVariable String number) {
		phoneBookService.deleteContact(number);
	}
}

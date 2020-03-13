package com.arun.phonebook.app;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//All the logging messages are handled at centralized location (LoggingAspect.java)

@RestController
public class PhoneBookController {

	Log logger = LogFactory.getLog(PhoneBookController.class);

	@Autowired
	private PhoneBookService phoneBookService;

	@RequestMapping(method = RequestMethod.POST, value = "/addContact")
	public void addContact(@RequestBody Contact contact) {
		try {
			phoneBookService.addContact(contact);
		} catch (Exception e) {
//			TODO
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/editContact")
	public void editContact(@RequestBody Contact contact) {
		try {
			phoneBookService.editContact(contact);
		} catch (Exception e) {
//			TODO
		}
	}

	@RequestMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = null;
		try {
			allContacts = phoneBookService.getAllContacts();
		} catch (Exception e) {
//			TODO
		}
		return allContacts;
	}

	@RequestMapping("/getContactByName/{name}")
	public Contact getContactByName(@PathVariable String name) {
		Contact contact = null;
		try {
			contact = phoneBookService.getContactByName(name);
		} catch (Exception e) {
//			TODO
		}
		return contact;
	}

	@RequestMapping("/getContactByNumber/{number}")
	public Contact getContactByNumber(@PathVariable String number) {
		Contact contact = null;
		try {
			contact = phoneBookService.getContactByNumber(number);
		} catch (Exception e) {
//			TODO
		}
		return contact;
	}

	@RequestMapping("/deleteContactByNumber/{number}")
	public void deleteContactByMobNumber(@PathVariable String number) {
		try {
			phoneBookService.deleteContactByMobNumber(number);
		} catch (Exception e) {
//			TODO
		}
	}

	@RequestMapping("/deleteContactByName/{name}")
	public void deleteContactByName(@PathVariable String name) {
		try {
			phoneBookService.deleteContactByName(name);
		} catch (Exception e) {
//			TODO
		}
	}
}

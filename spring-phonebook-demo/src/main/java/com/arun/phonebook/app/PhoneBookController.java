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

@RestController
public class PhoneBookController {

	Log logger = LogFactory.getLog(PhoneBookController.class);

	@Autowired
	private PhoneBookService phoneBookService;

	@RequestMapping(method = RequestMethod.POST, value = "/addContact")
	public void addContact(@RequestBody Contact contact) {
		logger.info("Inside addContact() method");
		try {
			phoneBookService.addContact(contact);
		} catch (Exception e) {
			logger.error(String.format("error while adding contact: {}", contact.getName()), e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/editContact")
	public void editContact(@RequestBody Contact contact) {
		logger.info("Inside editContact() method");
		try {
			phoneBookService.editContact(contact);
		} catch (Exception e) {
			logger.error(String.format("error while updating contact: {}", contact.getName()), e);
		}
	}

	@RequestMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		logger.info("Inside getAllContacts() method");
		List<Contact> allContacts = null;
		try {
			allContacts = phoneBookService.getAllContacts();
		} catch (Exception e) {
			logger.error("error in fetching all contacts", e);
		}
		return allContacts;
	}

	@RequestMapping("/getContactByName/{name}")
	public Contact getContactByName(@PathVariable String name) {
		logger.info("Inside getContactByName() method");
		Contact contact = null;
		try {
			contact = phoneBookService.getContactByName(name);
		} catch (Exception e) {
			logger.error(String.format("error while getting contact for name: {}", name), e);
		}
		return contact;
	}

	@RequestMapping("/getContactByNumber/{number}")
	public Contact getContactByNumber(@PathVariable String number) {
		logger.info("Inside getContactByNumber() method");
		Contact contact = null;
		try {
			contact = phoneBookService.getContactByNumber(number);
		} catch (Exception e) {
			logger.error(String.format("error while getting contact for number: {}", number), e);
		}
		return contact;
	}

	@RequestMapping("/deleteContactByNumber/{number}")
	public void deleteContactByMobNumber(@PathVariable String number) {
		logger.info("Inside deleteContactByMobNumber() method");
		try {
			phoneBookService.deleteContactByMobNumber(number);
		} catch (Exception e) {
			logger.error(String.format("error while deleting by number: {}", number), e);
		}
	}

	@RequestMapping("/deleteContactByName/{name}")
	public void deleteContactByName(@PathVariable String name) {
		logger.info("Inside deleteContactByName() method");
		try {
			phoneBookService.deleteContactByName(name);
		} catch (Exception e) {
			logger.error(String.format("error while deleting by name: {}", name), e);
		}
	}
}

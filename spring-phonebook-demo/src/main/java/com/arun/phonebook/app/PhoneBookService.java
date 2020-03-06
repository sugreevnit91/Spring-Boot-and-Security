package com.arun.phonebook.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookDao phoneBookDao;
	
	public void editContact(Contact contact) {
		phoneBookDao.save(contact);
	}
	
	public void addContact(Contact contact) {
		phoneBookDao.save(contact);
	}

	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		phoneBookDao.findAll().forEach(contactList::add);
		return contactList;
	}

	public void deleteContact(String id) {
		phoneBookDao.deleteById(id);
	}

	public Contact getContactByName(String name) {
		return phoneBookDao.findByName(name);
	}

	public Contact getContactByNumber(String number) {
		return phoneBookDao.findById(number).get();
	}
	
}

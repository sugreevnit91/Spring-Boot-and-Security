package com.arun.phonebook.app;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookDaoImpl phoneBookDaoImpl;

	@Transactional
	public void editContact(Contact contact) {
		phoneBookDaoImpl.updateContact(contact);
	}

	@Transactional
	public void addContact(Contact contact) {
		phoneBookDaoImpl.insertContact(contact);
	}

	@Transactional
	public List<Contact> getAllContacts() {
		return phoneBookDaoImpl.getAllContacts();
	}

	@Transactional
	public void deleteContactByName(String name) {
		phoneBookDaoImpl.deleteContactByName(name);
	}

	@Transactional
	public void deleteContactByMobNumber(String mobNumber) {
		phoneBookDaoImpl.deleteContactByMobNumber(mobNumber);
	}

	@Transactional
	public Contact getContactByName(String name) {
		return phoneBookDaoImpl.findByName(name);
	}

	@Transactional
	public Contact getContactByNumber(String mobNumber) {
		return phoneBookDaoImpl.findByMobNumber(mobNumber);
	}

}

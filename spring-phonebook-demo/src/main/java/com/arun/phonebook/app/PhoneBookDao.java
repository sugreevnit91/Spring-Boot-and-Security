package com.arun.phonebook.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookDao extends CrudRepository<Contact, String>{
	public Contact findByName(String name);
}

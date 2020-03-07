package com.arun.phonebook.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneBookDaoImpl {

	@Autowired
	private JdbcTemplate jdbcRead;

	public void updateContact(Contact contact) {
		insert("update contacts_info set name = ? where mob_number = ?",
				new Object[] { contact.getName(), contact.getMobNumber() });
	}

	public void insertContact(Contact contact) {
		insert("insert into contacts_info (name, mob_number) values(?, ?)",
				new Object[] { contact.getName(), contact.getMobNumber() });
	}

	public Contact findByName(String name) {
		return jdbcRead.queryForObject("select id, mob_number as mobNumber, name from contacts_info where name = ?",
				new Object[] { name }, new BeanPropertyRowMapper<>(Contact.class));
	}

	public Contact findByMobNumber(String mobNumber) {
		return jdbcRead.queryForObject("select id, mob_number as mobNumber, name from contacts_info where mob_number = ?",
				new Object[] { mobNumber }, new BeanPropertyRowMapper<>(Contact.class));
	}

	public List<Contact> getAllContacts() {
		List<Contact> contacts = jdbcRead.query("select id, mob_number as mobNumber, name from contacts_info",
				(ResultSet rs, int rowNum) -> {
					Contact contact = new Contact();
					contact.setId(rs.getInt(1));
					contact.setMobNumber(rs.getString(2));
					contact.setName(rs.getString(3));
					return contact;
				});
		return contacts;
	}

	public void deleteContactByMobNumber(String mobNumber) {
		insert("delete from contacts_info where mob_number = ?", new Object[] { mobNumber });
	}

	public void deleteContactByName(String name) {
		insert("delete from contacts_info where name = ?", new Object[] { name });
	}

	private int insert(String sql, Object[] args) {
		return jdbcRead.update(con -> {
			final PreparedStatement ps = con.prepareStatement(sql);
			new ArgumentPreparedStatementSetter(args).setValues(ps);
			return ps;
		});
	}

}

package com.security.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.jpa.models.MyUserDetails;
import com.security.jpa.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = UserRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + userName));
		return user.map(MyUserDetails::new).get();
	}
}

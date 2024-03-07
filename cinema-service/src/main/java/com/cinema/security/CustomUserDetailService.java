package com.cinema.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = ur.findByUsername(username);
		UserDetails ud = new CustomUserDetail(u);
		return ud;
	}
}
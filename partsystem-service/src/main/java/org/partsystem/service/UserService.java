package org.partsystem.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	
	public UserDetails loadUserByUsername(final String username) ;

}

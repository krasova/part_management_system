package org.partsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.partsystem.dao.UserDAO;
import org.partsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	 
	
	public UserDetails loadUserByUsername(final String username) 
               throws UsernameNotFoundException {
 
		org.partsystem.model.User user = userDAO.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
 
		return buildUserForAuthentication(user, authorities);
 
 
	}
 
	private User buildUserForAuthentication(org.partsystem.model.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), 
			user.getPassword(), user.isEnabled(), 
                        true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(List<String> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (String userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}
 
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
 
		return result;
	}

}

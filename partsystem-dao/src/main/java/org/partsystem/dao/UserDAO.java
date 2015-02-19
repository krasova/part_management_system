package org.partsystem.dao;

import org.partsystem.model.User;

public interface UserDAO {
	
	User findByUserName(String username);

}

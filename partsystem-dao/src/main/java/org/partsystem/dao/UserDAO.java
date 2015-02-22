package org.partsystem.dao;

import org.partsystem.model.User;

/**
 * @author Krasova Olga
 * Interface for @UserDAOImpl
 */
public interface UserDAO {
	
	/**
	 * Find user information for @UserService by username
	 * @param username
	 * @return @User
	 */
	User findByUserName(String username);

}

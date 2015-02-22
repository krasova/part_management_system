package org.partsystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.partsystem.dao.UserDAO;
import org.partsystem.dao.model.DAO_User;
import org.partsystem.dao.model.DAO_UserRole;
import org.partsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Krasova Olga
 * Find user information for @UserService by username
 */
@Repository
@Transactional 
public class UserDAOImpl implements UserDAO {	
	
	@Autowired
    private SessionFactory sessionFactory;
	 
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
 
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(DAO_User.class);
		c.add(Restrictions.eq("username", username));
		List<DAO_User> list = c.list();

		if (list.size() > 0) {
			DAO_User object = list.get(0);
			User user = new User();
			user.setUsername(object.getUsername());
			user.setPassword(object.getPassword());
			user.setEnabled(object.isEnabled());
			List<String> roles = new ArrayList<String>();
			for (DAO_UserRole userRole : object.getUserRoleList()){
				roles.add(userRole.getRole());
			}
			user.setRoles(roles);
			return user;
		} else {
			return null;
		}
 
	}

}

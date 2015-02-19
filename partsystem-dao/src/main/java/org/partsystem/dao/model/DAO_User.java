package org.partsystem.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class DAO_User {
	
	@Id
    @Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
    @OneToMany(mappedBy = "user")
    private List<DAO_UserRole> userRoleList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<DAO_UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<DAO_UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
    
    
}
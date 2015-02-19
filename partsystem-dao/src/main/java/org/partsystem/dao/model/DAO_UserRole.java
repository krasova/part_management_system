package org.partsystem.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class DAO_UserRole {
	
	@Id
    @Column(name = "id")
    @GeneratedValue
	private Integer id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "username")
	private DAO_User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public DAO_User getUser() {
		return user;
	}

	public void setUser(DAO_User user) {
		this.user = user;
	}
	
 
}
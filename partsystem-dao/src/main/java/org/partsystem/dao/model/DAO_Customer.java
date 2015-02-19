package org.partsystem.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.partsystem.model.Customer;

@Entity
@Table(name="customer")
public class DAO_Customer {
	
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;
    
//    @OneToMany(mappedBy = "customer")
//    private List<Project> projectList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Project> getProjectList() {
//		return projectList;
//	}
//
//	public void setProjectList(List<Project> projectList) {
//		this.projectList = projectList;
//	}
	
	public Customer toObject() {
		Customer recipient = new Customer();
		recipient.setId(id);
		recipient.setName(name);
		return recipient;
	}
    
    
}

package com.song.jap;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account {
	
	@Id @GeneratedValue
	private long id;
	private String username;
	private String password;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();
	
	@Embedded
	private Address  address;
	
	@OneToMany(mappedBy = "owner")//양방향 관계
	private Set<Study> stuodies = new  HashSet<>();
	
	public Set<Study> getStuodies() {
		return stuodies;
	}
	public void setStuodies(Set<Study> stuodies) {
		this.stuodies = stuodies;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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


}

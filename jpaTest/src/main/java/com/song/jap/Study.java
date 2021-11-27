package com.song.jap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {
	
	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToOne // 양방향 관계로 Account에서 관계 됨
	private Account owner;


	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}

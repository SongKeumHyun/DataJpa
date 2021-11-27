package com.song.jap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id @GeneratedValue
	private long id;

	private String title;
	
	@OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL )
	private Set<Comment> comments = new HashSet<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
		
	}

	
	public void addCommaent(Comment comment) {
		this.getComments().add(comment);
		comment.setPost(this);
	
	}
	
	

}

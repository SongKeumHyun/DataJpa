package com.song.jap.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.song.jap.Post;

@Repository
@Transactional
public class PostCustomRepositoryImpl  implements PostCustomRepository{

	
	@Autowired
	EntityManager  entityManager;
	
	@Override
	public List<Post> FindMyPost() {
		
		System.out.println("====> Custom Reposittory ");
		
		List<Post> posts = entityManager.createQuery(" SELECT p From Post As p", Post.class ).getResultList();
		
		return posts;
	}

}

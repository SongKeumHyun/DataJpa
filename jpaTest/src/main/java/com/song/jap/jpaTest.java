package com.song.jap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.jap.repository.PostRepository;


public class jpaTest {
	

	PostRepository postRepository;
	
	@Autowired
	public jpaTest(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}


	public void DoTest()
	{
		Post  post = new Post();
		post.setTitle("TEST");
		postRepository.save(post);
		
	}

}

package com.song.jap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Post post = new Post();
		post.setTitle("Sppinrg...");
		
		Comment comment = new Comment();
		comment.setComment("빨리보고싶어");
		
		Comment comment2 = new Comment();
		comment2.setComment("빨리보고싶어22222");
		
		
		post.addCommaent(comment);
		post.addCommaent(comment2);
		
		
		entityManager.persist(post);

		
		
		
		post = entityManager.getReference(Post.class, 1l);
		
		System.out.println(post.toString());
		
		post.getComments().forEach(c -> {
			System.out.println(c.getComment());
		}
		);
		

	

		


		
	}
	

}

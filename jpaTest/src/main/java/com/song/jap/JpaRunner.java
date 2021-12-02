package com.song.jap;

import java.io.Console;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.song.jap.repository.PostRepository;

import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

//	@PersistenceContext
//	EntityManager entityManager;
	@Autowired
	PostRepository postRepository;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void run(ApplicationArguments args) throws Exception {
		

/*		
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
		
		
		
		TypedQuery<Post> query = entityManager.createQuery("SELECT p From Post as p", Post.class);
		
		List<Post> posts = query.getResultList();
		
		for(Post p : posts)
		{
			System.out.println(p.toString());
		}
		
*/		
/*
		JSONObject data = new JSONObject();
		
		data.put("name", "song");
		data.put("age", "20");
		
		JSONObject rootJSon = new JSONObject();
		
		rootJSon.put("data", data);
		
		System.out.println(rootJSon.toJSONString());
*/
		
		Post post = new Post();
		post.setTitle("Sppinrg...");
		postRepository.save(post);
		postRepository.findAll().forEach(System.out::println);
		
		
	}
	

}

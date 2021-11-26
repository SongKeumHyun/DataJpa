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
		
		Account account = new Account();
		account.setUsername("song2");
		account.setPassword("1234");
		
		Study study = new Study();
		
		study.setName("Spring Data Jpa");
		entityManager.persist(study);
		account.getStuodies().add(study);
		
		study =  new Study();
		
		study.setName("Spring Data Jpa 22");
		entityManager.persist(study);
		account.getStuodies().add(study);


	
		entityManager.persist(account);
		


		
	}
	

}

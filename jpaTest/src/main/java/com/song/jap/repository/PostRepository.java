package com.song.jap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.jap.Post;

public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository{
	
}

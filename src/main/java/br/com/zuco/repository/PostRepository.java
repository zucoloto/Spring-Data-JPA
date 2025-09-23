package br.com.zuco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuco.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {}

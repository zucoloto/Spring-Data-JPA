package br.com.zuco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zuco.repository.PostRepository;

@Service
public class PostService {

	@Autowired
    private PostRepository postRepository;
    
}

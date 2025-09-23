package br.com.zuco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zuco.service.PostService;

@RestController
@RequestMapping("posts")
public class PostController {

	@Autowired
    private PostService postService;
	
}

package br.com.zuco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.entity.Autor;
import br.com.zuco.entity.Categoria;
import br.com.zuco.entity.Post;
import br.com.zuco.repository.PostRepository;

@Service
public class PostService {

	@Autowired
    private PostRepository postRepository;
	
	@Autowired
    private AutorService autorService;
    
	@Autowired
    private CategoriaService categoriaService;
    
	@Transactional
    public Post salvar(Post post) {
        Autor autor = autorService.buscarPorId(post.getAutor().getAutorId());
        post.setAutor(autor);

        List<String> titulos = post.getCategorias().stream().map(Categoria::getCategoriaTitulo).toList();
        List<Categoria> categorias = categoriaService.buscarPorTitulos(titulos);
        post.setCategorias(categorias);

        return this.postRepository.save(post);
    }
	
}

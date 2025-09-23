package br.com.zuco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zuco.entity.Categoria;
import br.com.zuco.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional
    public List<Categoria> salvar(List<Categoria> categorias) {
        return categoriaRepository.saveAll(categorias);
    }
	
	public Categoria buscarPorTitulo(String titulo) {
        return categoriaRepository.findByCategoriaTitulo(titulo).orElseGet(Categoria::new);
    }
	
	public List<Categoria> buscarPorInicioTitulo(String titulo) {
        return categoriaRepository.findByCategoriaTituloStartsWith(titulo);
    }

    public List<Categoria> buscarPorTitulos(List<String> titulos) {
        return categoriaRepository.findByCategoriaTituloIn(titulos);
    }

    public List<Categoria> buscarTodosOrdemPorTituloAsc() {
        return categoriaRepository.findByOrderByCategoriaTituloAsc();
    }
	
}

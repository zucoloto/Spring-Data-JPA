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
}

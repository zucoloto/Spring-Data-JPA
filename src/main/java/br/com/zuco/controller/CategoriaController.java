package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zuco.entity.Categoria;
import br.com.zuco.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
    public List<Categoria> salvar(@RequestBody List<Categoria> categorias) {
        return categoriaService.salvar(categorias);
    }
	
}

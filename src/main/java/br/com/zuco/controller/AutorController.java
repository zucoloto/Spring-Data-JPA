package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zuco.model.Autor;
import br.com.zuco.service.AutorService;

@RestController
@RequestMapping("autores")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@PostMapping
	public Autor salvar(@RequestBody Autor autor) {
		autorService.salvar(autor);
		return autor;
	}

	@PutMapping
	public Autor atualizar(@RequestBody Autor autor) {
		autorService.atualizar(autor);
		return autor;
	}

	@DeleteMapping("{id}")
	public void excluir(@PathVariable Long id) {
		autorService.excluir(id);
	}

	@GetMapping
	public List<Autor> buscarTodos() {
		return autorService.buscarTodos();
	}

	@GetMapping("{id}") 
	public Autor buscarPorId(@PathVariable Long id) {
		return autorService.buscarPorId(id);
	}

}

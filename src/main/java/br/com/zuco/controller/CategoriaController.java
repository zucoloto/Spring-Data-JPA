package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("titulo/{titulo}")
    public Categoria buscarPorTitulo(@PathVariable String titulo) {
        return categoriaService.buscarPorTitulo(titulo);
    }
	
	@GetMapping("titulo/inicio/{titulo}")
    public List<Categoria> buscarPorInicioTitulo(@PathVariable String titulo) {
        return categoriaService.buscarPorInicioTitulo(titulo);
    }

    @GetMapping("titulos")
    public List<Categoria> buscarPorTitulos(@RequestParam(name = "t") List<String> titulos) {
        return categoriaService.buscarPorTitulos(titulos);
    }

    @GetMapping
    public List<Categoria> buscarTodasCategoriasOrdenadasAsc() {
        return categoriaService.buscarTodosOrdemPorTituloAsc();
    }
	
}

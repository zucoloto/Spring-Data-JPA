 package br.com.zuco.service;

import java.util.List;

import br.com.zuco.model.Autor;
import br.com.zuco.model.InfoAutor;

public interface AutorService {

	void salvar(Autor autor);
	
	void atualizar(Autor autor);
	
	void excluir(Long id);
	
	List<Autor> buscarTodos();
	
	Autor buscarPorId(Long id);
	
	List<Autor> buscarPorCargo(String cargo);
	
	List<Autor> buscarTodosPorNomeOuSobrenome(String termo);
	
	Long getTotalAutores();
	
	Autor salvarInfoAutor(InfoAutor infoAutor, Long autorId);

}

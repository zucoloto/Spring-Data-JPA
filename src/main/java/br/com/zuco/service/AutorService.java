package br.com.zuco.service;

import java.util.List;

import br.com.zuco.model.Autor;
import br.com.zuco.model.InfoAutor;

public interface AutorService {

	public void salvar(Autor autor);
	
	public void atualizar(Autor autor);
	
	public void excluir(Long id);
	
	public List<Autor> buscarTodos();
	
	public Autor buscarPorId(Long id);
	
	public Autor salvarInfoAutor(InfoAutor infoAutor, Long autorId);
}

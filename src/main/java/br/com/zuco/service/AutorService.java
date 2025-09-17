package br.com.zuco.service;

import java.util.List;

import br.com.zuco.model.Autor;

public interface AutorService {

	public Autor salvar(Autor autor);
	
	public Autor atualizar(Autor autor);
	
	public void excluir(Long id);
	
	public List<Autor> buscarTodos();
	
	public Autor buscarPorId(Long id);
}

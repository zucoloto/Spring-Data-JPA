package br.com.zuco.service;

import java.util.List;

import br.com.zuco.model.InfoAutor;

public interface InfoAutorService {

	InfoAutor buscarPorId(Long id);

	List<InfoAutor> buscarTodosContemCargo(String cargo);

	List<InfoAutor> buscarTodosCargoEhEmpresa(String cargo, String empresa);

	InfoAutor buscarPorBio(String bio);

}

package br.com.zuco.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zuco.model.Autor;
import br.com.zuco.repository.AutorRepository;
import br.com.zuco.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	private Logger _log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public Autor salvar(Autor autor) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.save(autor);

		_log.info("[Registro salvo!]");
		return autor;
	}

	@Override
	public Autor atualizar(Autor autor) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.save(autor);

		_log.info("[Registro atualizado!]");
		return autor;
	}

	@Override
	public void excluir(Long id) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Autor autor = autorRepository.findById(id).orElseThrow();
		autorRepository.delete(autor);
		
		_log.info("[Registro deletado!]");
	}

	@Override
	public List<Autor> buscarTodos() {
		List<Autor> listar = autorRepository.findAll();
		return listar;
	}

	@Override
	public Autor buscarPorId(Long id) {
		Autor autor = autorRepository.findById(id).orElseThrow();
		return autor;
	}

}

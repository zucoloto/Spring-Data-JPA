package br.com.zuco.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.model.Autor;
import br.com.zuco.model.InfoAutor;
import br.com.zuco.repository.AutorRepository;
import br.com.zuco.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	private Logger _log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	@Transactional(readOnly = false)
	public void salvar(Autor autor) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.save(autor);

		_log.info("[Registro salvo!]");
	}

	@Override
	@Transactional(readOnly = false)
	public void atualizar(Autor autor) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.save(autor);

		_log.info("[Registro atualizado!]");
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Autor autor = autorRepository.findById(id).orElseThrow();
		autorRepository.delete(autor);
		
		//autorRepository.deleteById(id);
		
		_log.info("[Registro deletado!]");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Autor> buscarTodos() {
		List<Autor> listar = autorRepository.findAll();
		return listar;
	}

	@Override
	@Transactional(readOnly = true)
	public Autor buscarPorId(Long id) {
		Autor autor = autorRepository.findById(id).orElseThrow();
		return autor;
	}
	
	@Override
	@Transactional(readOnly = true)
    public List<Autor> buscarPorCargo(String cargo) {
		List<Autor> listar = autorRepository.findByCargo("%" + cargo + "%");
		return listar;
    }
	
	@Override
	@Transactional(readOnly = true)
    public List<Autor> buscarTodosPorNomeOuSobrenome(String termo) {
        return autorRepository.findAllByNomeOrSobrenome("%" + termo + "%");
    }
	
	@Override
	@Transactional(readOnly = true)
	public Long getTotalAutores() {
		Long quantidade = autorRepository.count();
		return quantidade;
	}
	
	@Override
	@Transactional(readOnly = false)
    public Autor salvarInfoAutor(InfoAutor infoAutor, Long autorId) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Autor autor = buscarPorId(autorId);
        autor.setInfoAutor(infoAutor);
        
        _log.info("[Registro salvo!]");
        return autor;
    }

}

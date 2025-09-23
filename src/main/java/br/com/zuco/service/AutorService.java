package br.com.zuco.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.entity.Autor;
import br.com.zuco.entity.InfoAutor;
import br.com.zuco.exception.ResourceNotFoundException;
import br.com.zuco.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Transactional
	public void salvar(Autor autor) {
		logger.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.save(autor);

		logger.info("[Registro salvo!]");
	}

	@Transactional
	public void atualizar(Autor autor) {
		logger.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");

		autorRepository.findById(autor.getAutorId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		autorRepository.save(autor);

		logger.info("[Registro atualizado!]");
	}

	@Transactional
	public void excluir(Long id) {
		logger.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Autor autor = autorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		autorRepository.delete(autor);
		
		logger.info("[Registro deletado!]");
		logger.info("[ID:]"+id);
	}

	public List<Autor> buscarTodos() {
		List<Autor> listar = autorRepository.findAll();
		return listar;
	}

	public Autor buscarPorId(Long id) {
		Autor autor = autorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		return autor;
	}
	
    public List<Autor> buscarPorCargo(String cargo) {
		List<Autor> listar = autorRepository.findByCargo("%" + cargo + "%");
		return listar;
    }
	
    public List<Autor> buscarTodosPorNomeOuSobrenome(String termo) {
        return autorRepository.findAllByNomeOrSobrenome1("%" + termo + "%");
    }
	
    public Long getTotalElementos() {
        return autorRepository.count();
    }
	
    @Transactional
    public Autor salvarInfoAutor(InfoAutor infoAutor, Long autorId) {
		logger.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Autor autor = buscarPorId(autorId);
        autor.setInfoAutor(infoAutor);
        
        logger.info("[Registro salvo!]");
        return autor;
    }

}

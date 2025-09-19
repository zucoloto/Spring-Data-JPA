package br.com.zuco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.model.InfoAutor;
import br.com.zuco.repository.InfoAutorRepository;
import br.com.zuco.service.InfoAutorService;

@Service
@Transactional(readOnly = true)
public class InfoAutorServiceImpl implements InfoAutorService {
	
	@Autowired
	private InfoAutorRepository infoAutorRepository;

	@Override
	public InfoAutor buscarPorId(Long id) {
		InfoAutor info = new InfoAutor();
		info.setId(id);
		return infoAutorRepository.findOne(Example.of(info)).orElseGet(InfoAutor::new);
	}
	
	@Override
	public List<InfoAutor> buscarTodosContemCargo(String cargo) {
		InfoAutor info = new InfoAutor();
		info.setCargo(cargo);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("cargo",
				ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findAll(Example.of(info, matcher));
	}

	@Override
	public List<InfoAutor> buscarTodosCargoEhEmpresa(String cargo, String empresa) {
		InfoAutor info = new InfoAutor();
		info.setCargo(cargo);
		info.setBio(empresa);

		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withMatcher("cargo", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withMatcher("bio", ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findAll(Example.of(info, matcher));
	}

	@Override
	public InfoAutor buscarPorBio(String bio) {
		InfoAutor info = new InfoAutor();
		info.setBio(bio);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("bio",
				ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findBy(Example.of(info, matcher), query -> query.sortBy(Sort.by("cargo").descending()).first())
				.orElseGet(InfoAutor::new);
	}
	
}

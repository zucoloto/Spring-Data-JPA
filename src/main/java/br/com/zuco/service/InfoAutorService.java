package br.com.zuco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.zuco.entity.InfoAutor;
import br.com.zuco.repository.InfoAutorRepository;

@Service
public class InfoAutorService {

	@Autowired
	private InfoAutorRepository infoAutorRepository;

	public InfoAutor buscarPorId(Long id) {
		InfoAutor info = new InfoAutor();
		info.setInfoId(id);
		return infoAutorRepository.findOne(Example.of(info)).orElseGet(InfoAutor::new);
	}
	
	public List<InfoAutor> buscarTodosContemCargo(String cargo) {
		InfoAutor info = new InfoAutor();
		info.setInfoCargo(cargo);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("infoCargo",
				ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findAll(Example.of(info, matcher));
	}

	public List<InfoAutor> buscarTodosCargoEhEmpresa(String cargo, String empresa) {
		InfoAutor info = new InfoAutor();
		info.setInfoCargo(cargo);
		info.setInfoBio(empresa);

		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withMatcher("infoCargo", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withMatcher("infoBio", ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findAll(Example.of(info, matcher));
	}

	public InfoAutor buscarPorBio(String bio) {
		InfoAutor info = new InfoAutor();
		info.setInfoBio(bio);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("infoBio",
				ExampleMatcher.GenericPropertyMatchers.contains());

		return infoAutorRepository.findBy(Example.of(info, matcher), query -> query.sortBy(Sort.by("infoCargo").descending()).first())
				.orElseGet(InfoAutor::new);
	}
	
}

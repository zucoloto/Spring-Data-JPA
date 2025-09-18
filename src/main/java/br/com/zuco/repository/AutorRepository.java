package br.com.zuco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.zuco.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	@Query("select a from Autor a where a.infoAutor.cargo like :cargo order by a.nome asc")
	List<Autor> findByCargo(@Param("cargo") String cargo);
	
	@Query("select a from Autor a where a.nome like :termo OR a.sobrenome like :termo")
	List<Autor> findAllByNomeOrSobrenome(String termo);
	
}

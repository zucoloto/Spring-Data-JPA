package br.com.zuco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.zuco.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	@Query("select a from Autor a where a.infoAutor.infoCargo like :cargo order by a.autorNome asc")
	List<Autor> findByCargo(@Param("cargo") String cargo);
	
	@Query("select a from Autor a where a.autorNome like :termo OR a.autorSobreNome like :termo")
	List<Autor> findAllByNomeOrSobrenome1(String termo);
	
	// OU
	
	@Query("select a from Autor a where a.autorNome like ?1 OR a.autorSobreNome like ?1")
	List<Autor> findAllByNomeOrSobrenome2(String termo);
	
}

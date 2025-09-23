package br.com.zuco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuco.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Optional<Categoria> findByCategoriaTitulo(String titulo);
	
	List<Categoria> findByCategoriaTituloStartsWith(String titulo);

    List<Categoria> findByCategoriaTituloIn(List<String> titulos);

    List<Categoria> findByOrderByCategoriaTituloAsc();
	
}

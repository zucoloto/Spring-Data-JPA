package br.com.zuco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zuco.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {}

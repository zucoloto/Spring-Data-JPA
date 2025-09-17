package br.com.zuco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuco.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {}

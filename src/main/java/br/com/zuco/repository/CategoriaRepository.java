package br.com.zuco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuco.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}

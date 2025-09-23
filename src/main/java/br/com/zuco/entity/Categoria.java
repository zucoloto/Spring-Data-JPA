package br.com.zuco.entity;

import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private Long categoriaId;

    @Column(name = "categoria_titulo", length = 45, nullable = false, unique = true)
    private String categoriaTitulo;

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoriaTitulo() {
		return categoriaTitulo;
	}

	public void setCategoriaTitulo(String categoriaTitulo) {
		this.categoriaTitulo = categoriaTitulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(categoriaId, other.categoriaId);
	}

	@Override
	public String toString() {
		return "Categoria [categoriaId=" + categoriaId + "]";
	}
    
}

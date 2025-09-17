package br.com.zuco.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id", nullable = false)
	private Long id;
	
	@Column(name = "autor_nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "autor_sobrenome", length = 45, nullable = false)
	private String sobrenome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + "]";
	}
	
}

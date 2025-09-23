package br.com.zuco.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autor_id", nullable = false)
	private Long autorId;
	
	@Column(name = "autor_nome", length = 45, nullable = false)
	private String autorNome;
	
	@Column(name = "autor_sobrenome", length = 45, nullable = false)
	private String autorSobreNome;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "info_id")
    private InfoAutor infoAutor;

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public String getAutorNome() {
		return autorNome;
	}

	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}

	public String getAutorSobreNome() {
		return autorSobreNome;
	}

	public void setAutorSobreNome(String autorSobreNome) {
		this.autorSobreNome = autorSobreNome;
	}
	
	public InfoAutor getInfoAutor() {
		return infoAutor;
	}

	public void setInfoAutor(InfoAutor infoAutor) {
		this.infoAutor = infoAutor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(autorId, other.autorId);
	}

	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + "]";
	}
	
}

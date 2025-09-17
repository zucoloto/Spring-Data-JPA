package br.com.zuco.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "info_autores")
public class InfoAutor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id", nullable = false)
    private Long id;

    @Column(name = "info_cargo", length = 45, nullable = false)
    private String cargo;

    @Column(name = "info_bio", length = 255, nullable = true)
    private String bio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoAutor other = (InfoAutor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "InfoAutor [id=" + id + "]";
	}

}

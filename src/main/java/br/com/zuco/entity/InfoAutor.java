package br.com.zuco.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_autor")
public class InfoAutor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id", nullable = false)
    private Long infoId;

    @Column(name = "info_cargo", length = 45, nullable = false)
    private String infoCargo;

    @Column(name = "info_bio", length = 255, nullable = true)
    private String infoBio;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getInfoCargo() {
		return infoCargo;
	}

	public void setInfoCargo(String infoCargo) {
		this.infoCargo = infoCargo;
	}

	public String getInfoBio() {
		return infoBio;
	}

	public void setInfoBio(String infoBio) {
		this.infoBio = infoBio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(infoId);
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
		return Objects.equals(infoId, other.infoId);
	}

	@Override
	public String toString() {
		return "InfoAutor [infoId=" + infoId + "]";
	}

}

package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto.FlorDto;

import javax.persistence.GenerationType;

@Entity
@Table(name="sucursals")
public class FlorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer pk_FlorID;
	
	@Column(name = "nom")
	String nomFlor;
	
	@Column(name = "pais")
	String paisFlor;
	
	public FlorEntity() {};
	
	public FlorEntity(String nom, String pais) {
		this.nomFlor = nom;
		this.paisFlor = pais;
	}
	
	
	public FlorEntity(FlorDto florDto) {
		super();
		this.pk_FlorID = florDto.getPk_FlorID();
		this.nomFlor = florDto.getNomFlor();
		this.paisFlor = florDto.getPaisFlor();
	}

	
	public Integer getPk_FlorID() {
		return pk_FlorID;
	}


	public String getNomFlor() {
		return nomFlor;
	}

	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

	@Override
	public String toString() {
		return "id=" + pk_FlorID + ", nom=" + nomFlor + ", pais=" + paisFlor + "\n";
	}	

}

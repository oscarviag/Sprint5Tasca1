package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto;

import java.util.Arrays;
import java.util.List;


import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.domain.FlorEntity;


public class FlorDto {
	

	Integer pk_FlorID;
	String nomFlor;
	String paisFlor;
	String tipusFlor;
	List<String> països= Arrays.asList("Portugal","Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania","Rumanía");
	
		
	public FlorDto(FlorEntity flor) {
		super();
		this.pk_FlorID = flor.getPk_FlorID();
		this.nomFlor = flor.getNomFlor();
		this.paisFlor = flor.getPaisFlor();
		if (països.contains(flor.getPaisFlor())) {this.tipusFlor="UE";} else {this.tipusFlor="No UE";}
	}
	
	public FlorDto(String nom, String pais) {
		this.nomFlor = nom;
		this.paisFlor = pais;
	}

	
	public Integer getPk_FlorID() {
		return pk_FlorID;
	}

	public void setPk_FlorID(Integer pk_FlorID) {
		this.pk_FlorID = pk_FlorID;
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

	public String getTipusFlor() {
		return tipusFlor;
	}

	public void setTipusFlor(String tipusFlor) {
		this.tipusFlor = tipusFlor;
	}

	@Override
	public String toString() {
		return "id=" + pk_FlorID + ", nom=" + nomFlor + ", pais=" + paisFlor +  ", pertany a =" + tipusFlor + "\n";
	}	

}

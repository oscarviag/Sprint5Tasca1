package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.domain.Sucursal;


public class SucursalDto {
	

	Integer pk_SucursalID;
	String nomSucursal;
	String paisSucursal;
	String tipusSucursal;
	List<String> països= Arrays.asList("Portugal","Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría", "Italia", "Lituania","Rumanía");
	
	
	public SucursalDto() {
	
	}
	
	public SucursalDto(Sucursal sucursal) {
		super();
		this.pk_SucursalID = sucursal.getPk_SucursalID();
		this.nomSucursal = sucursal.getNomSucursal();
		this.paisSucursal = sucursal.getPaisSucursal();
		if (països.contains(sucursal.getPaisSucursal())) {this.tipusSucursal="UE";} else {this.tipusSucursal="No UE";}
	}
	
	public SucursalDto(Integer id, String nom, String pais) {
		this.pk_SucursalID = id;
		this.nomSucursal = nom;
		this.paisSucursal = pais;
		if (països.contains(pais)) {this.tipusSucursal="UE";} else {this.tipusSucursal="No UE";}
	}
	
	
	public SucursalDto(String nom, String pais) {
		this.nomSucursal = nom;
		this.paisSucursal = pais;
		if (països.contains(pais)) {this.tipusSucursal="UE";} else {this.tipusSucursal="No UE";}
	}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}
	
	public void setPk_SucursalID(Integer pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	
	
	
	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}

	@Override
	public String toString() {
		return "id=" + pk_SucursalID + ", nom=" + nomSucursal + ", pais=" + paisSucursal + "\n" +  ", pertany a =" + tipusSucursal + "\n";
	}	

}

package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto.SucursalDto;

import javax.persistence.GenerationType;

@Entity
@Table(name="sucursals")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer pk_SucursalID;
	
	@Column(name = "nom")
	String nomSucursal;
	
	@Column(name = "pais")
	String paisSucursal;
	
	public Sucursal() {};
	
	public Sucursal(String nom, String pais) {
		this.nomSucursal = nom;
		this.paisSucursal = pais;
	}
	
	
	public Sucursal(SucursalDto sucursalDto) {
		super();
		this.pk_SucursalID = sucursalDto.getPk_SucursalID();
		this.nomSucursal = sucursalDto.getNomSucursal();
		this.paisSucursal = sucursalDto.getPaisSucursal();
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
	
	@Override
	public String toString() {
		return "id=" + pk_SucursalID + ", nom=" + nomSucursal + ", pais=" + paisSucursal + "\n";
	}	

}

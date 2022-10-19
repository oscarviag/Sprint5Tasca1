package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.services;

import org.springframework.stereotype.Component;


import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto.SucursalDto;

@Component
public class SucursalConverter {
	
	public SucursalDto convertirEntitatADto(Sucursal sucursal) {
		
		SucursalDto sucursalDto = new SucursalDto(sucursal);
		return sucursalDto;
	}
	
	public Sucursal convertirDtoAEntitat(SucursalDto sucursalDto) {
		
		Sucursal sucursal = new Sucursal(sucursalDto);
		return sucursal;
	}

}

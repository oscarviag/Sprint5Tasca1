package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.services;

import org.springframework.stereotype.Component;


import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto.FlorDto;

@Component
public class FlorConverter {
	
	public FlorDto convertirEntitatADto(FlorEntity flor) {
		
		FlorDto florDto = new FlorDto(flor);
		return florDto;
	}
	
	public FlorEntity convertirDtoAEntitat(FlorDto florDto) {
		
		FlorEntity flor = new FlorEntity(florDto);
		return flor;
	}

}

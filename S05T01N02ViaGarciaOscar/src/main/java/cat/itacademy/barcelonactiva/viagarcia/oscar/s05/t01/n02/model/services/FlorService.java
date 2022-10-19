package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.repository.FlorRepository;





@Service
public class FlorService implements Services{
	
	@Autowired
	private FlorRepository florRepository;
	
	public FlorDto add(FlorDto florDto) {
		
		FlorEntity flor = new FlorEntity(florDto);
		
		FlorDto florDtoRetorn = new FlorDto(florRepository.save(flor));
		
		return florDtoRetorn;
	}
	
	public FlorDto getOne(int id) {
		
		FlorDto florDto = new FlorDto(florRepository.findById(id).orElse(null));
		
		return florDto;
	}
	
	public List<FlorDto> getAll() {	
		
		List<FlorEntity> llistat = new ArrayList<>(florRepository.findAll());
		List<FlorDto> llistatDto = new ArrayList<>();
		
		for(FlorEntity entitat:llistat) {	
			
			llistatDto.add(new FlorDto(entitat));
			System.out.println(entitat.toString());
		}
		
		return llistatDto;
	}

	public FlorDto update(FlorDto florDto) {
		
		FlorEntity flor = new FlorEntity(florDto);
		
		Optional<FlorEntity> florExisteix = florRepository.findById(flor.getPk_FlorID());
		FlorEntity florAntiga = null;
		
		if (florExisteix.isPresent()) {
			
			florAntiga = florExisteix.get();
			florAntiga.setNomFlor(flor.getNomFlor());
			florAntiga.setPaisFlor(flor.getPaisFlor());
			florRepository.save(florAntiga);
			
		} else {
			
			florAntiga = new FlorEntity();
		}
		
		FlorDto FlorDtoRetorn = new FlorDto(florAntiga);
		
		return FlorDtoRetorn;
			
	}
	
	public String delete(int id) {
		
		florRepository.deleteById(id);
		return "Flor esborrada";
		
	}
	
	
}

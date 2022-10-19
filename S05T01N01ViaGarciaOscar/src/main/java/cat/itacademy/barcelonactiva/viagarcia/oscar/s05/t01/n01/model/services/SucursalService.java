package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.repository.SucursalRepository;





@Service
public class SucursalService implements Services{
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	public SucursalDto add(SucursalDto sucursalDto) {
		
		Sucursal sucursal = new Sucursal(sucursalDto);		
		SucursalDto sucursalDtoRetorn = new SucursalDto(sucursalRepository.save(sucursal));	
		return sucursalDtoRetorn;
	}
	
	public SucursalDto getOne(int id) {
		
		SucursalDto sucursalDto = new SucursalDto(sucursalRepository.findById(id).orElse(null));		
		return sucursalDto;
	}
	
	public List<SucursalDto> getAll() {	
		
		List<Sucursal> llistat = new ArrayList<>(sucursalRepository.findAll());
		List<SucursalDto> llistatDto = new ArrayList<>();
		
		for(Sucursal entitat:llistat) {	
			
			llistatDto.add(new SucursalDto(entitat));
		}		
		return llistatDto;
	}

	public SucursalDto update(SucursalDto sucursalDto) {
		
		Sucursal sucursal = new Sucursal(sucursalDto);
		sucursalRepository.save(sucursal);	
		SucursalDto sucusalDtoRetorn = new SucursalDto(sucursal);
		return sucusalDtoRetorn;
			
	}
	
	public String delete(int id) {
		
		sucursalRepository.deleteById(id);
		return "Sucursal esborrada";
		
	}
	
	
}

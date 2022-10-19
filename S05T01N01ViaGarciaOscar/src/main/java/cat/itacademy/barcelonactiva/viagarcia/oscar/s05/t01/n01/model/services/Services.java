package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.services;

import java.util.List;


import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto.SucursalDto;


public interface Services {
	
	public SucursalDto add(SucursalDto sucursalDto);
	
	public SucursalDto getOne(int id);
	
	public List<SucursalDto> getAll();

	public SucursalDto update(SucursalDto sucursalDto);
	
	public String delete(int id);

}

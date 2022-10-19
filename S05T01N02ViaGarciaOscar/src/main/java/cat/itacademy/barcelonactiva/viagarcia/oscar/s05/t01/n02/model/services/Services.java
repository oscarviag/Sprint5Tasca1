package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto.FlorDto;


public interface Services {
	
	public FlorDto add(FlorDto florDto);
	
	public FlorDto getOne(int id);
	
	public List<FlorDto> getAll();

	public FlorDto update(FlorDto florDto);
	
	public String delete(int id);

}

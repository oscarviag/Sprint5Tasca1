package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.dto.FlorDto;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n02.model.services.Services;


@CrossOrigin(origins = "http://localhost:9001")
@RestController
@RequestMapping("/flor")
public class FlorController {
	
	@Autowired
	private Services florService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody FlorDto florDto) {
			
			FlorDto novaFlor = florService.add(florDto);
			
			System.out.println(novaFlor.toString());
			
			if (novaFlor.getPk_FlorID()!=0 )
				
				return new ResponseEntity<>(novaFlor.toString() + "Afegida a la BD\n", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("No s'ha pogut crear la flor a la BD", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<String> getOne(@PathVariable int id) {
		try {
			
			FlorDto novaFlor = florService.getOne(id);
			
			System.out.println(novaFlor.toString());
			
			return new ResponseEntity<>(novaFlor.toString(), HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Aquest index no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<String> getAll() {

			List<FlorDto> totesFlors = florService.getAll();
			
			if (!totesFlors.isEmpty()) 
				return new ResponseEntity<>(totesFlors.toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen flors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
		
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody FlorDto florDto) {
			
			FlorDto florActualitzada = florService.update(florDto);
			
			if (florActualitzada.getPk_FlorID() != 0)
				
				return new ResponseEntity<>(florActualitzada.toString() + " Flor actualitzada", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("Aquest index no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		try {
			
			florService.delete(id);
			
			return new ResponseEntity<>("Flor esborrada", HttpStatus.CREATED);
		}
		catch (Exception e) { 
		
			return new ResponseEntity<>("Aquesta flor no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	}

	
	
}

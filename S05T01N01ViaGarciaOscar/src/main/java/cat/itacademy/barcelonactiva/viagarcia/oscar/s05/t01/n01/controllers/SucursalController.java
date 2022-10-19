package cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.viagarcia.oscar.s05.t01.n01.model.services.Services;


@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private Services sucursalService;
	
	
	@GetMapping("/signup")
    public String showSignUpForm(Model model) {		
		model.addAttribute("sucursalDto", new SucursalDto());		
        return "add-sucursal";
    }
    
    @PostMapping("/add")
    public String add(SucursalDto sucursal, BindingResult result, Model model) {   	
        if (result.hasErrors()) {
            return "add-sucursal";
        }      
        sucursalService.add(sucursal);       
        return "redirect:/sucursal/getAll";
    }
	
	
	
	@GetMapping("/getOne/{id}")
	public String getOne(@PathVariable("id") int id, Model model) {		
			SucursalDto sucursalUpdate = sucursalService.getOne(id);
			model.addAttribute("sucursalDto", sucursalUpdate);		
			return "update-sucursal";	
		
	}
	
	
	@GetMapping({"/index","/getAll"})
	public String getAll(Model model) {		
		List<SucursalDto> totesSucursals = sucursalService.getAll();	
		if (!totesSucursals.isEmpty()) 
			System.out.println("Si que hi ha llistat");		
		else System.out.println("No hi ha llistat");		
	    model.addAttribute("sucursalDtos", totesSucursals);	    
	    return "index";
	}
	
	
	@PostMapping("/update")
	public String update(SucursalDto sucursalDto) {				
		sucursalService.update(sucursalDto);		
	    return "redirect:/sucursal/getAll";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {		
		try {			
			sucursalService.delete(id);			
		}
		catch (Exception e) { 		
			new IllegalArgumentException("Aquesta sucursal no existeix Id:" + id);				
		}
	    return "redirect:/sucursal/getAll";
	}	
	
}

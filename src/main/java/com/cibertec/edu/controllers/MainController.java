package com.cibertec.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.models.Product;
import com.cibertec.edu.repositories.ProductDao;
import com.cibertec.edu.services.ProductService;
import com.cibertec.edu.services.ProductServicelmpl;

@Controller
@RequestMapping(value="/producto")
public class MainController {
	
	@Autowired
	private ProductServicelmpl productService;
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","JASPER REPORT + SPRING BOOT");
		return "index";
	}
	
	@Autowired
	private ProductDao productRepository;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/registro")
	public String registro(@ModelAttribute("producto") Product producto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			return "registro";
		} else {
			return "acceso_denegado";
		}
	}

	@PostMapping("/registro")
    public String registrarEstudiante(@Validated @ModelAttribute("producto") Product producto, BindingResult bindingResult) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
        	if (bindingResult.hasErrors()) {
                return "registro";
            }
            
        	productRepository.save(producto);
            
            return "redirect:/";
        } else {
        	return "acceso-denegado";
        }    	
    }
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}		
}

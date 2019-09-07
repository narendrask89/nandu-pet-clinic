package nandu.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nandu.springframework.petclinic.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({ "", "/index", "/index.html" })
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
}

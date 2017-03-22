package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entities.Owner;
import com.example.Repositories.OwnerRepository;

@Controller
public class OwnerController {

	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@RequestMapping(value="/ownerPage/{ownerName}", method = RequestMethod.GET)
	public String ownerPage(Model model, @PathVariable String ownerName) {	
		return "ownerPage";
	
	}
	@RequestMapping(value="/owner/", method = RequestMethod.POST)
	public String createowner(Model model,@RequestParam String ownername,@RequestParam String ownersurname,
			@RequestParam String ownerdni,@RequestParam long ownerphone, 
			@RequestParam String ownerperc,@RequestParam String owneraccount) {
		model.addAttribute("owners", ownerRepository.findAll());
		Owner owner = new Owner (ownerdni, ownername, ownersurname, ownerphone);
		ownerRepository.save(owner);
		return "owner";
	}
	
	@RequestMapping(value="/ownerPage/", method = RequestMethod.GET)
	public String ownerPage(Model model) {	
		return "ownerPage";
	}
}

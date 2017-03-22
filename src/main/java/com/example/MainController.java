package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entities.Property;
import com.example.Repositories.CommunityRepository;
import com.example.Repositories.OwnerRepository;
import com.example.Repositories.PropertyRepository;

@Controller
public class MainController {
	
	@Autowired
	CommunityRepository communityRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PropertyRepository propertyRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("communities", communityRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String main(Model model, @RequestParam (required=false) String cif) {
		model.addAttribute("community", communityRepository.findByCif(cif));
		model.addAttribute("communities", communityRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value="/community/", method = RequestMethod.GET)
	public String communityGet(Model model) {	
		model.addAttribute("communities", communityRepository.findAll());
		return "community";
	}
	
	@RequestMapping(value="/community/", method = RequestMethod.POST)
	public String communityPost(Model model) {	
		model.addAttribute("communities", communityRepository.findAll());
		return "community";
	}
	
	@RequestMapping(value="/communityPage/{cif}", method = RequestMethod.GET)
	public String communityPage(Model model, @PathVariable String cif) {	
		return "communityPage";
	}

	@RequestMapping(value="/property/", method = RequestMethod.GET)
	public String propertyGet(Model model) {	
		model.addAttribute("properties", propertyRepository.findAll());
		return "property";
	}
	
	@RequestMapping(value="/property/", method = RequestMethod.POST)
	public String propertyPost(Model model) {	
		return "property";
	}
	
	@RequestMapping(value="/propertyPage/{id}", method = RequestMethod.GET)
	public String propertyPageGet(Model model, @PathVariable long id) {
		model.addAttribute("communities", communityRepository.findAll());
		model.addAttribute("property", propertyRepository.findOne(id));
		model.addAttribute("owners", ownerRepository.findAll());
		return "propertyPage";
	}
	
	@RequestMapping(value="/propertyPage/{id}", method = RequestMethod.POST)
	public String propertyPagePost(Model model, @PathVariable long id, @RequestParam int portalnumber, @RequestParam int floor, @RequestParam char letter, @RequestParam String ownerCommunity, @RequestParam String propertyCommunity) {
		model.addAttribute("property", propertyRepository.findOne(id));
		model.addAttribute("communities", communityRepository.findAll());
		model.addAttribute("owners", ownerRepository.findAll());
		Property property = propertyRepository.findOne(id);
		property.setNumber(portalnumber);
		property.setFloor(floor);
		property.setLetter(letter);
		property.setOwner(ownerRepository.findByName(ownerCommunity));
		property.setCommunity(communityRepository.findByCif(propertyCommunity));
		propertyRepository.save(property);
		return "propertyPage";
	}

	
	@RequestMapping("/error/")
	public String error(Model model) {
		return "error";
	}

	
}
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/communityPage/", method = RequestMethod.GET)
	public String communityPage(Model model) {	
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
	public String propertyPage(Model model, @PathVariable long id) {
		return "propertyPage";
	}

	
	@RequestMapping("/error/")
	public String error(Model model) {
		return "error";
	}

	
}
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Repositories.CommunityRepository;

@Controller
public class MainController {
	
	@Autowired
	CommunityRepository communityRepository;

	
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
	public String community(Model model) {	
		return "community";
	}
	
	@RequestMapping(value="/communityPage/", method = RequestMethod.GET)
	public String communityPage(Model model) {	
		return "communityPage";
	}
	
	@RequestMapping(value="/owner/", method = RequestMethod.GET)
	public String owner(Model model) {	
		return "owner";
	}
	
	@RequestMapping(value="/ownerPage/", method = RequestMethod.GET)
	public String ownerPage(Model model) {	
		return "ownerPage";
	}
	@RequestMapping(value="/property/", method = RequestMethod.GET)
	public String property(Model model) {	
		return "property";
	}
	
	@RequestMapping(value="/propertyPage/", method = RequestMethod.GET)
	public String propertyPage(Model model) {	
		return "propertyPage";
	}

	
	@RequestMapping("/error/")
	public String error(Model model) {
		return "error";
	}

	
}
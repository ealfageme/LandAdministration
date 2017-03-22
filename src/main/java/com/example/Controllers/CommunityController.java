package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entities.Community;
import com.example.Repositories.CommunityRepository;

@Controller
public class CommunityController {

	@Autowired
	CommunityRepository communityRepository;
	
	@RequestMapping(value="/community/", method = RequestMethod.GET)
	public String communityGet(Model model) {	
		model.addAttribute("communities", communityRepository.findAll());
		return "community";
	}
	
	@RequestMapping(value="/community/", method = RequestMethod.POST)
	public String communityPost(Model model,@RequestParam String cif,@RequestParam String street,@RequestParam int numbercommunity
			,@RequestParam int postalcode,@RequestParam int population,@RequestParam String bankaccountco) {	
		Community community = new Community (cif,street,numbercommunity, postalcode,population, bankaccountco);
		communityRepository.save(community);
		model.addAttribute("communities", communityRepository.findAll());
		return "community";
	}
}

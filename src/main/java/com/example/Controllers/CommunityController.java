package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	

	@RequestMapping(value="/communityPage/{cif}", method = RequestMethod.GET)
	public String communityPageGet(Model model, @PathVariable String cif) {	
		model.addAttribute("community", communityRepository.findByCif(cif));
		return "communityPage";
	}
	
	@RequestMapping(value="/communityPage/{cif}", method = RequestMethod.POST)
	public String communityPagePost(Model model, @PathVariable String cif, @RequestParam String cifCommunity, @RequestParam String street, @RequestParam int number, @RequestParam int postalCode, @RequestParam int population, @RequestParam String bankAccount) {
		model.addAttribute("community", communityRepository.findByCif(cif));
		Community community = communityRepository.findByCif(cif);
		community.setCif(cifCommunity);
		community.setStreet(street);
		community.setNumber(number);
		community.setPostalCode(postalCode);
		community.setPopulation(population);
		community.setBankAccount(bankAccount);
		communityRepository.save(community);
		return "redirect:/communityPage/"+cifCommunity;
	}
}

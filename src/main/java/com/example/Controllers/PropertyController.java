package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entities.Owner;
import com.example.Entities.Property;
import com.example.Repositories.CommunityRepository;
import com.example.Repositories.OwnerRepository;
import com.example.Repositories.PropertyRepository;

@Controller
public class PropertyController {

	@Autowired
	PropertyRepository propertyRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	CommunityRepository communityRepository;
	
	@RequestMapping(value="/property/", method = RequestMethod.GET)
	public String propertyGet(Model model) {	
		model.addAttribute("properties", propertyRepository.findAll());
		model.addAttribute("owners", ownerRepository.findAll());
		model.addAttribute("communities", communityRepository.findAll());
		return "property";
	}
	
	@RequestMapping(value="/property/", method = RequestMethod.POST)
	public String propertyPost(Model model, @RequestParam int portalnumber,@RequestParam int floor,@RequestParam char letter,
			@RequestParam long selectowner) {
		System.out.println(selectowner);
		Property property = new Property (portalnumber, floor, letter , 0);
		//property.setCommunity(community);
		Owner owner = ownerRepository.findById(selectowner);
		property.setOwner(owner);
		propertyRepository.save(property);
		return "property";
	}
	
	@RequestMapping(value="/propertyPage/{id}", method = RequestMethod.GET)
	public String propertyPage(Model model, @PathVariable long id) {
		return "propertyPage";
	}
}

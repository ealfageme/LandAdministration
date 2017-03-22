package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Entities.Community;
import com.example.Entities.Owner;
import com.example.Entities.Property;
import com.example.Repositories.CommunityRepository;
import com.example.Repositories.OwnerRepository;
import com.example.Repositories.PropertyRepository;

@Controller
public class MainController {
	
	
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	CommunityRepository communityRepository;
	@Autowired
	PropertyRepository propertyRepository;

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("communities", communityRepository.findAll());
		return "home";

	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String main(Model model, @RequestParam String cif,@RequestParam(required=false) String option1,
			@RequestParam(required=false) String option2, @RequestParam String optionSelected) {
		model.addAttribute("community", communityRepository.findByCif(cif));
		model.addAttribute("communities", communityRepository.findAll());
		
		Community community=communityRepository.findByCif(cif);
		
		switch(optionSelected){
			case "portalNumber":
				model.addAttribute("search", propertyRepository.findByNumberAndCommunity(Integer.parseInt(option1),community));
				break;
			case "portalNumberFloor":
				model.addAttribute("search", propertyRepository.findByNumberAndFloorAndCommunity(Integer.parseInt(option1),Integer.parseInt(option2),community));
				break;
			case "surname":
				Owner owner=ownerRepository.findBySurname(option1);
				List<Property> properties=new ArrayList<>();
				if(owner!=null){
					for(int i=0;i<community.getCommunityproperties().size();i++){
						if(community.getCommunityproperties().get(i).getOwner().getId()==owner.getId()){
							properties.add(community.getCommunityproperties().get(i));
						}
					}
				}
				model.addAttribute("search", properties);
				break;
			case "DNI":
				Owner owner2=ownerRepository.findByDni(option1);
				List<Property> properties2=new ArrayList<>();
				if(owner2!=null){
					for(int i=0;i<community.getCommunityproperties().size();i++){
						if(community.getCommunityproperties().get(i).getOwner().getId()==owner2.getId()){
							properties2.add(community.getCommunityproperties().get(i));
						}
					}
				}
				model.addAttribute("search", properties2);				
				break;
			case "wholeCommunity":
				model.addAttribute("search", communityRepository.findByCif(cif));
				break;
		}
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/communityPage/{cif}", method = RequestMethod.GET)
	public String communityPage(Model model, @PathVariable String cif) {	
		return "communityPage";
	}



	
	@RequestMapping("/error/")
	public String error(Model model) {
		return "error";
	}

	
}
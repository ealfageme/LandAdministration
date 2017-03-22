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


@Controller
public class MainController {
	
	
	@Autowired
	OwnerRepository ownerRepository;
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
<<<<<<< HEAD
	
	
=======
>>>>>>> 4d323e41f0b7d36b3d2f4ba05f0c804c43971715



	
	@RequestMapping("/error/")
	public String error(Model model) {
		return "error";
	}

	
}
package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	@RequestMapping(value="/home/", method = RequestMethod.GET)
	public String main(Model model) {	
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
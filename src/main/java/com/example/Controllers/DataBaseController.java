package com.example.Controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.example.Entities.Community;
import com.example.Entities.Owner;
import com.example.Entities.Property;
import com.example.Repositories.CommunityRepository;
import com.example.Repositories.OwnerRepository;
import com.example.Repositories.PropertyRepository;



@Controller
public class DataBaseController implements CommandLineRunner {

	@Autowired
	private CommunityRepository communityRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private PropertyRepository propertyRepository;
	
	@PostConstruct
    private void initDatabase() {
		

		Owner owner1 = new Owner("78945329G", "John","Snow", 324131236,"234567-8765");
		Owner owner2 = new Owner("12242329H", "Ragnar","Lootbrock", 304132481,"234567-8765");
		Owner owner3 = new Owner("87645329S", "Emmanuel","Rodrigues", 1421304012,"234567-8765");
		Owner owner4 = new Owner("32945329Y", "Amapola","Fuertes", 340234823,"234567-8765");
		Owner owner5 = new Owner("23945329A", "Paola","Lola", 695098231,"234567-8765");
		Owner owner6 = new Owner("38945329B", "Hector","Domingues", 403241233,"436234-3124");
		Owner owner7 = new Owner("32945123Y", "Nieves","Torrente", 63288403,"23321-4132");
		Owner owner8 = new Owner("23945123A", "Judas","Gamez", 691323123,"234231-2131");
		Owner owner9 = new Owner("38945123B", "Filipe","Filipinas", 695123123,"123456-2312");

		
		ownerRepository.save(owner1);
		ownerRepository.save(owner2);
		ownerRepository.save(owner3);
		ownerRepository.save(owner4);
		ownerRepository.save(owner5);
		ownerRepository.save(owner6);
		ownerRepository.save(owner7);
		ownerRepository.save(owner8);
		ownerRepository.save(owner9);
		
		Community community1 = new Community("H423423-12312", "C/Tulipan", 12,28312, 30000,"765432-23456");
		Community community2 = new Community("H645466-21346", "C/Leganes", 1,42342, 60000,"765432-3456");
		Community community3 = new Community("H123434-41234", "C/LaPan Tomima", 1,432422, 80000,"734234-9082");
		
		communityRepository.save(community1);
		communityRepository.save(community2);
		communityRepository.save(community3);
		
		Property property1 = new Property(2,4,'A',43.81);
		Property property2 = new Property(1,3,'B',63.72);
		Property property3 = new Property(4,5,'C',64.65);
		Property property4 = new Property(21,4,'A',56.81);
		Property property5 = new Property(123,3,'B',30.72);
		Property property6 = new Property(123,5,'C',27.65);
		Property property7 = new Property(21,4,'B',30.81);
		Property property8 = new Property(21,3,'B',15.72);
		Property property9 = new Property(44,5,'C',64.65);
		Property property10 = new Property(2,4,'A',43.81);
		Property property11 = new Property(1,3,'B',63.72);
		Property property12 = new Property(44,5,'B',12.65);
		
		property1.setCommunity(community1);
		property2.setCommunity(community2);
		property3.setCommunity(community2);
		property4.setCommunity(community1);
		property5.setCommunity(community3);
		property6.setCommunity(community3);
		property7.setCommunity(community1);
		property8.setCommunity(community1);
		property9.setCommunity(community1);
		property10.setCommunity(community2);
		property11.setCommunity(community2);
		property12.setCommunity(community3);
		
		property1.setOwner(owner1);
		property2.setOwner(owner2);
		property3.setOwner(owner3);
		property4.setOwner(owner4);
		property5.setOwner(owner5);
		property6.setOwner(owner6);
		property7.setOwner(owner7);
		property8.setOwner(owner8);
		property9.setOwner(owner8);
		property10.setOwner(owner9);
		property11.setOwner(owner1);
		property12.setOwner(owner1);
		
		
		propertyRepository.save(property1);
		propertyRepository.save(property2);
		propertyRepository.save(property3);
		propertyRepository.save(property4);
		propertyRepository.save(property2);
		propertyRepository.save(property5);
		propertyRepository.save(property6);
		propertyRepository.save(property7);
		propertyRepository.save(property8);
		propertyRepository.save(property9);
		propertyRepository.save(property10);
		propertyRepository.save(property11);
		propertyRepository.save(property12);
		
		
	community1.getCommunityproperties().add(property1);
	community2.getCommunityproperties().add(property2);
	community2.getCommunityproperties().add(property3);
	community1.getCommunityproperties().add(property4);
	community2.getCommunityproperties().add(property10);
	community2.getCommunityproperties().add(property11);
	community1.getCommunityproperties().add(property7);
	community3.getCommunityproperties().add(property5);
	community3.getCommunityproperties().add(property6);
	community1.getCommunityproperties().add(property8);
	community1.getCommunityproperties().add(property9);
	community3.getCommunityproperties().add(property12);
	
	communityRepository.save(community1);
	communityRepository.save(community2);
	communityRepository.save(community3);
	
	owner1.getOwnerProperties().add(property1);
	owner1.getOwnerProperties().add(property12);
	owner1.getOwnerProperties().add(property11);
	owner2.getOwnerProperties().add(property2);
	owner3.getOwnerProperties().add(property3);
	owner4.getOwnerProperties().add(property4);
	owner5.getOwnerProperties().add(property5);
	owner6.getOwnerProperties().add(property6);
	owner7.getOwnerProperties().add(property7);
	owner8.getOwnerProperties().add(property8);
	owner8.getOwnerProperties().add(property9);
	owner9.getOwnerProperties().add(property10);
	ownerRepository.save(owner1);
	ownerRepository.save(owner2);
	ownerRepository.save(owner3);
	ownerRepository.save(owner4);
	ownerRepository.save(owner5);
	ownerRepository.save(owner6);
	ownerRepository.save(owner7);
	ownerRepository.save(owner8);
	ownerRepository.save(owner9);
	
	
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

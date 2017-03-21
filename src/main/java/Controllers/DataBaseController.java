package Controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import Entities.Community;
import Entities.Owner;
import Entities.Property;
import Repositories.CommunityRepository;
import Repositories.OwnerRepository;
import Repositories.PropertyRepository;



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
		
		Owner owner1 = new Owner("78945329G", "propertyname1","propertySurname", 695339576);
		Owner owner2 = new Owner("12242329H", "propertyname2","propertySurname", 695339576);
		Owner owner3 = new Owner("87645329S", "propertyname3","propertySurname", 695339576);
		Owner owner4 = new Owner("32945329Y", "propertyname4","propertySurname", 695339576);
		Owner owner5 = new Owner("23945329A", "propertyname5","propertySurname", 695339576);
		Owner owner6 = new Owner("38945329B", "propertyname6","propertySurname", 695339576);
		
		ownerRepository.save(owner1);
		ownerRepository.save(owner2);
		ownerRepository.save(owner3);
		ownerRepository.save(owner4);
		ownerRepository.save(owner5);
		ownerRepository.save(owner6);
		
		Community community1 = new Community("423423-12312", "C/Tulipan", 12,28312, 30000,312324214);
		Community community2 = new Community("645466-21346", "C/Leganes", 1,42342, 60000,423423423);
		
		communityRepository.save(community1);
		communityRepository.save(community2);
		
		Property property1 = new Property(2,4,'A',43.81);
		Property property2 = new Property(1,3,'B',63.72);
		Property property3 = new Property(4,5,'C',64.65);
		
		property1.setCommunity(community1);
		property2.setCommunity(community2);
		property3.setCommunity(community2);
		
		property1.setOwner(owner1);
		property2.setOwner(owner2);
		property3.setOwner(owner3);
		
		
		propertyRepository.save(property1);
		propertyRepository.save(property2);
		propertyRepository.save(property3);
		
		
	community1.getCommunityproperties().add(property1);
	community2.getCommunityproperties().add(property2);
	community2.getCommunityproperties().add(property3);
	
	communityRepository.save(community1);
	communityRepository.save(community2);
	
	owner1.getOwnerProperties().add(property1);
	owner2.getOwnerProperties().add(property2);
	owner3.getOwnerProperties().add(property3);
	ownerRepository.save(owner1);
	ownerRepository.save(owner2);
	ownerRepository.save(owner3);
	ownerRepository.save(owner4);
	ownerRepository.save(owner5);
	ownerRepository.save(owner6);
	
	
		
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

package nandu.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nandu.springframework.petclinic.model.Owner;
import nandu.springframework.petclinic.model.Vet;
import nandu.springframework.petclinic.services.OwnerService;
import nandu.springframework.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Santosh");
		owner1.setLastName("Sahu");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Narendra");
		owner2.setLastName("Sahu");
		
		ownerService.save(owner2);
		
		System.out.println("Load Owners");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Test");
		vet1.setLastName("test");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Test");
		vet2.setLastName("test");
		
		vetService.save(vet2);
		
		System.out.println("Load Vets");
	}

}

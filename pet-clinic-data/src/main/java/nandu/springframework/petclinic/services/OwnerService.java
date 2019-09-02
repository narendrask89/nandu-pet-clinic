package nandu.springframework.petclinic.services;

import nandu.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

	Owner findByLastName(String lastName);

}

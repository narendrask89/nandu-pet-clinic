package nandu.springframework.petclinic.services;

import java.util.Set;

import nandu.springframework.petclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> findAll();
}

package org.bykova.rest.service.implementation;

import org.bykova.rest.entity.Pet;
import org.bykova.rest.repository.PetRepository;
import org.bykova.rest.service.api.IPetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IPetService")
public class PetService implements IPetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

}

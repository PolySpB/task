package org.bykova.rest.service.api;

import org.bykova.rest.entity.Pet;

import java.util.List;

public interface IPetService {
    List<Pet> findAll();
}

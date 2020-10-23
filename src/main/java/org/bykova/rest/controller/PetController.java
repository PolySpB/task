package org.bykova.rest.controller;

import org.bykova.rest.entity.Pet;
import org.bykova.rest.service.api.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/pet_service")
public class PetController {

    private final IPetService petService;
    private final DataSource dataSource;

    @Autowired
    public PetController(IPetService petService, DataSource dataSource) {
        this.petService = petService;
        this.dataSource = dataSource;
    }

    @GetMapping("/pets")
    public List<Pet> findAll() {
        return petService.findAll();
    }

    // Пример использования JDBC/Datasource.
    @GetMapping("/pets/{row_id}")
    public Object findById(@PathVariable("row_id") Long id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("id", id);
        Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM pets WHERE pet_id=:id", paramMap);
        return result;
    }
}



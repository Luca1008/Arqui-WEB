package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.repository.CarreraRepository;

@RestController
@RequestMapping("persons")
@Api(value = "CarreraControllerJpa", description = "REST API Person description")
public class CarreraControllerJpa {

    @Qualifier("CarreraRepository")
    @Autowired
    private final CarreraRepository repository;
    
}


public class PersonControllerJpa {

    @Qualifier("CarreraRepository")
    @Autowired
    private final CarreraRepository repository;

    public PersonControllerJpa(@Qualifier("personRepository") PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/BySurname/{surname}")

    
    public Iterable<Person> getPersonsBySurname(@PathVariable String surname) {
        return repository.findAllBySurname(surname);
    }

    @GetMapping("/ByName/{name}")
    public Iterable<Person> getPersonsByName(@PathVariable String name) {
        return repository.findAllByName(name);
    }

    @PostMapping("/")
    public Person newPerson(@RequestBody Person p) {
        return repository.save(p);
    }

    @ApiOperation(value = "Get specific Person in the System ", response = Person.class, tags = "getPerson")
    @RequestMapping(value = "/getPerson/{name}")
    public Person getPerson(@PathVariable(value = "name") String name) {
        return repository.findAllByName(name).get(0);
    }
    @GetMapping("/{id}")
    Optional<Person> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setSurname(newPerson.getSurname());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setDni(id);
                    return repository.save(newPerson);
                });
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

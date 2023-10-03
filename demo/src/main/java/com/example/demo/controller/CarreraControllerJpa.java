package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;

@RestController
@RequestMapping("carrera")
public class CarreraControllerJpa {

    @Qualifier("carreraRepository")
    @Autowired
    private final CarreraRepository repository;
    
    public CarreraControllerJpa(@Qualifier("carreraRepository") CarreraRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/carreras/conEstudiantesOrdenado/")
    public List<Carrera> findCarrerasConInscriptos(){return repository.carrerasConInscriptos();}
}
    //GET - Obtener todos los registros de la tabla carrera
//     @RequestMapping("/")
//     public Iterable<Carrera> getCarreras() {
//         return repository.findAll();
//     }
    
//     //GET - Obtener un registro de la tabla carrera
//     @RequestMapping("/{id}")
    
//     public Carrera getCarrera(@PathVariable int id) {
//         return repository.findById((long) id).get();
//     }
    
//     //POST - Crear un registro de la tabla carrera

//     @RequestMapping("/new")
//     public Carrera newCarrera(@RequestBody Carrera c) {
//         return repository.save(c);
//     }
    
//     //PUT - Actualizar un registro de la tabla carrera

//     @RequestMapping("/update")
//     public Carrera updateCarrera(@RequestBody Carrera c) {
//         return repository.save(c);
//     }
    
//     //DELETE - Eliminar un registro de la tabla carrera

//     @RequestMapping("/delete/{id}")
//     public void deleteCarrera(@PathVariable int id) {
//         repository.deleteById((long) id);
//     }

// }


/* public class PersonControllerJpa {

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
}*/

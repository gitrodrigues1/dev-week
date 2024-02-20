package br.com.marcos.devweek.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marcos.devweek.model.Person;
import br.com.marcos.devweek.service.impl.PersonServiceImpl;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/person")
public class PersonController {
    
    private PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        var person = personService.findById(id);
        return ResponseEntity.ok(person);
    }
    
    @PostMapping
    public ResponseEntity<Person> findById(@RequestBody Person person) {
        var newPerson = personService.create(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPerson.getId())
                .toUri();

        return ResponseEntity.created(location).body(newPerson);
    }

}

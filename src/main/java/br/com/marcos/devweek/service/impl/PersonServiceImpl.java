package br.com.marcos.devweek.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.marcos.devweek.model.Person;
import br.com.marcos.devweek.repository.PersonRepository;
import br.com.marcos.devweek.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Person create(Person personToCreate) {
        if(personToCreate.getId() != null && personRepository.existsById(personToCreate.getId())) {
            throw new IllegalArgumentException("This is user id already exists.");
        }
        return personRepository.save(personToCreate);
    }
    
}

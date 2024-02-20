package br.com.marcos.devweek.service;

import br.com.marcos.devweek.model.Person;

public interface IPersonService {
    
    Person findById(Long id);

    Person create(Person personToCreate);
}

package br.com.marcos.devweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.devweek.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}

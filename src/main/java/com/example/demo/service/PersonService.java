package com.example.demo.service;


import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(@Qualifier("mysql") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(UUID id) { return personRepository.findById(id);}

    public void deletePersonById(UUID id){
        personRepository.deleteById(id);
    }

    public Person updatePersonById(UUID id, Person person) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if(existingPerson.isPresent()){
            Person p = existingPerson.get();
            p.setName(person.getName());
            return personRepository.save(p);
        }
        else
            return null;
    }
}

package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql_dao")
public class MysqlDao  implements PersonDao{

    private PersonRepository repository;
    @Override
    public Person insertPerson(UUID id, Person person) {
        return repository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deletePersonById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Person updatePersonById(UUID id, Person person) {
        Optional<Person> existingPerson = repository.findById(id);
        if(existingPerson.isPresent()){
            Person p = existingPerson.get();
            p.setId(person.getId());
            p.setName(person.getName());
            return repository.save(person);
        }
        else
            return null;
    }
}

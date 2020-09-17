package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.UUID;

@Entity
public class Person {

    @Column(name = "id")
    @PrimaryKeyJoinColumn
    @Id
    private UUID id;
    @Column(name="name")
    private String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id){this.id = id;}

    public void setName(String name){this.name = name;}
}

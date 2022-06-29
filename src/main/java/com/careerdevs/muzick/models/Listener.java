package com.careerdevs.muzick.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Listener {
    @Id
    // we are using identity because it will not allow
    // influence from other tables that will be created
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // using this annotation to require a not null value
    @NotNull
    private String name;
    private Integer age;
    // later we will add genre and user

    @OneToMany(mappedBy = "listener",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Note> notes;

   // jpa needs a default constructor
    public Listener() {
    }

    public Listener(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Listener{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

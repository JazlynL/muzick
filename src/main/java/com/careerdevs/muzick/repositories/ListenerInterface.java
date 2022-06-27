package com.careerdevs.muzick.repositories;

import com.careerdevs.muzick.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// An interface is an implementation of methods and properties to a class
// you are not able to instantiate objects from an interface
// List is an example of interface.


// listener is the entity we are going to access , Then we will be using Long data type.

public interface ListenerInterface extends JpaRepository<Listener,Long> {


    
    List<Listener> findAllByAge(Integer age);

}

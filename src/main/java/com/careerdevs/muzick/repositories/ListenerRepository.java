package com.careerdevs.muzick.repositories;

import com.careerdevs.muzick.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
// An interface is an implementation of methods and properties to a class
// you are not able to instantiate objects from an interface
// List is an example of interface.


// listener is the entity we are going to access , Then we will be using Long data type.

public interface ListenerRepository extends JpaRepository<Listener,Long> {



    List<Listener> findAllByAge(Integer age);

    // query annotation , we can use query placeholders
    // can only be used to annotate repository interface methods. The call of the annotated methods will trigger the execution of the statement found in it, and their usage is pretty straightforward.
    // The @Query annotation supports both native SQL and JPQL.
   // @Query("Select * From listener WHERE name LIKE '%?1%'")
    List <Listener> findAllByName(String name);

}

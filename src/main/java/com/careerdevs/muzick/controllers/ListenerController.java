package com.careerdevs.muzick.controllers;

import com.careerdevs.muzick.models.Listener;
import com.careerdevs.muzick.repositories.ListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

//
@CrossOrigin
@RestController
@RequestMapping("/api/listeners")

public class ListenerController {

    @Autowired
    private ListenerRepository listenerRepository;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute(){
        return new ResponseEntity<>("This test Works!", HttpStatus.OK);
    }


    //Request body will Take the data as a JSON object and convert it to a java object
    //AKA deserialize the Json object to be read in Java.

    @PostMapping("/")
    public ResponseEntity<?> createListener(@RequestBody Listener newListener){
        Listener listener = listenerRepository.save(newListener);

        return new ResponseEntity<>(listener,HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<?> getListener(){
       List<Listener> foundListener = listenerRepository.findAll();
       return new ResponseEntity<>(foundListener,HttpStatus.OK);

    }
    @GetMapping("/{id}")
  public ResponseEntity<?> getListenerById (@PathVariable ("id")  String foundId) {
        Long foundIDNum = Long.parseLong(foundId);
        Optional<Listener> finalId = listenerRepository.findById(foundIDNum);
        if(finalId.isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Not Found");
        }

        return new ResponseEntity<>(finalId.get(),HttpStatus.OK);


    }
}

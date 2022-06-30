package com.careerdevs.muzick.controllers;

import com.careerdevs.muzick.models.Listener;
import com.careerdevs.muzick.models.Note;
import com.careerdevs.muzick.repositories.ListenerRepository;
import com.careerdevs.muzick.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private ListenerRepository listenerRepository;
    @Autowired
    private NoteRepository noteRepository;



    @GetMapping("/test")
    public ResponseEntity<?> testRoute(){
        return  new ResponseEntity<>("note route", HttpStatus.OK);
    }

    @PostMapping("/{listenerId}")
    public ResponseEntity<?> createNote(@PathVariable Long listenerId,@RequestBody Note newNote){
       Listener listener = listenerRepository.findById(listenerId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        newNote.setListener(listener);

           Note note = noteRepository.save(newNote);

           return new ResponseEntity<>(note,HttpStatus.CREATED);

    }
    @GetMapping("/{id}")

    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note note = noteRepository.findById(id).orElseThrow(
        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
    );
        return  new ResponseEntity<>(note,HttpStatus.OK);
    }


    @GetMapping("/")
    public  ResponseEntity<List<Note>> getAll(){
        List<Note> foundALl = noteRepository.findAll();
        return new ResponseEntity<>(foundALl,HttpStatus.OK);

    }
}

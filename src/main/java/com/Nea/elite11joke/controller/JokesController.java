package com.Nea.elite11joke.controller;

import com.Nea.elite11joke.models.Joke;
import com.Nea.elite11joke.repo.JokeRepository;
import com.Nea.elite11joke.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200") //connect backend to frontend
public class JokesController {

    @Autowired  //Dependency Injection
    private JokesService jokesService;

    @Autowired
    private JokeRepository jokeRepository;

    //C.R.U.D
    //Create - Post
    //Read - Get
    //Update - Put
    //Delete - delete

    @PostMapping("/jokes")
    public void addJoke(@RequestBody Joke joke){
        jokesService.saveJoke(joke);
    }

    @PutMapping("/jokes/{id}")
    public Joke updateJoke(@PathVariable Long id, @RequestBody Joke joke){
        return jokesService.updateJoke(id,joke);
    }

    //get a single joke by id
    @GetMapping("/jokes/{id}")
    public Optional<Joke> getJokeById(@PathVariable Long id) {
        return this.jokesService.getJoke(id);
    }

    //come up w a delete functionality- so that we can delete a joke
    @DeleteMapping("/jokes/{id}")
    public  void deleteById(@PathVariable Long id){
        jokesService.deleteJoke(id);
    }

    @GetMapping("/jokes")
    public List<Joke> getAllJokes( @RequestParam(required = false) String category){
        if(category != null){
            return jokeRepository.findJokesByCategory(category);
        }
        return jokesService.getAllJokes();
    }



}

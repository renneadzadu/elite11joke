package com.Nea.elite11joke.services;

import com.Nea.elite11joke.models.Joke;
import com.Nea.elite11joke.repo.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class JokesService {
    @Autowired
    private JokeRepository jokeRepository;

    //Fake DB
//
//    List<Joke> listOfJokes = new ArrayList<>(
//            Arrays.asList(
//                    new Joke(1L, "what is red and bad for ya teeth - a Brick"),
//                    new Joke(2L, "how do u mae a napkin dance - put a lil booger in it"),
//                    new Joke(3L, "what kind of tea is hot to swallow - Reality")
//            )
//    );


    public void saveJoke(Joke joke){
        jokeRepository.save(joke);
    }


    public List<Joke> getAllJokes(){
        List<Joke> jokes = new ArrayList<>();
        jokeRepository.findAll().forEach(jokes::add);
        return jokes;
    }


    public Joke updateJoke(Long jokeId, Joke joke) {
        for (Joke j : getAllJokes()) {
            if (j.getId()==jokeId) {
                jokeRepository.save(joke);
            }
        }
        return joke;
    }


    public Optional<Joke> getJoke(Long id){
        return jokeRepository.findById(id);
    }

    public void deleteJoke(Long id){
        jokeRepository.deleteById(id);
        }


}

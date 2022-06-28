package com.Nea.elite11joke.repo;

import com.Nea.elite11joke.models.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Long> {

List<Joke> findJokesByCategory(String category);
 }
// hw read the book



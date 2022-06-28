package com.Nea.elite11joke.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joke { //the joke has an id and a value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key
    private String value;
    private  String category;

    public Joke(){ // has a default constructor
    }


    public Joke(Long id, String value, String category) {
        this.id = id;
        this.value = value;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

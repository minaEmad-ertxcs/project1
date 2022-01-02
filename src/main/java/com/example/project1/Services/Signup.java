package com.example.project1.Services;

import com.example.project1.model.Person;

public interface Signup<T extends Person> {
    void signUp(T person);
}

//driver wa user

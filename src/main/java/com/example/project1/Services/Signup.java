package com.example.project1.Services;

import com.example.project1.model.Person;

public interface Signup<T extends Person> {
    T signUp(T person);
}

//driver wa user

package com.becadev.first_spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// o lombok vai gerar automaticamente os getters e setters
public class User {
    private String name;
    private String email;
}

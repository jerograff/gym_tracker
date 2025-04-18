package com.dashi.gymtracker.model.user;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    // If the user is a TRAINER, this list will hold his/her students
    @OneToMany
    private List<User> students = new ArrayList<>();

    // Later, we could add TrainingSessions list here for easier access
}


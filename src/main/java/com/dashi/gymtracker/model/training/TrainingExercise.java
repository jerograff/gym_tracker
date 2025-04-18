package com.dashi.gymtracker.model.training;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private TrainingSession trainingSession;

    @ManyToOne(optional = false)
    private Exercise exercise;

    @OneToMany(mappedBy = "trainingExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingSerie> series = new ArrayList<>();
}

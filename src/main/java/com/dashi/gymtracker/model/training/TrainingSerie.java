package com.dashi.gymtracker.model.training;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TrainingSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private TrainingExercise trainingExercise;

    private int serieNumber;

    private double weightUsed; // kg

    private int repsDone;

    private int restAfterSerie; // seconds
}
package com.dashi.gymtracker.model.planning;

import com.dashi.gymtracker.model.training.Exercise;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PlannedExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private PlannedSession plannedSession;

    @ManyToOne(optional = false)
    private Exercise exercise;

    private int targetSets;
    private int targetReps;
    private double suggestedWeight;
    private int restSeconds;
}

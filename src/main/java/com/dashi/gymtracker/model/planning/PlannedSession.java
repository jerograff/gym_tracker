package com.dashi.gymtracker.model.planning;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PlannedSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dayOfWeek; // 1 = Monday, 2 = Tuesday, etc.

    private String title;

    @ManyToOne(optional = false)
    private WorkoutRoutine routine;

    @OneToMany(mappedBy = "plannedSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlannedExercise> exercises;
}

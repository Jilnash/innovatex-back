package com.example.hackinnovatix.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suggestion")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    @Column(name = "is_urgent")
    private Boolean isUrgent;

    private String message;
}

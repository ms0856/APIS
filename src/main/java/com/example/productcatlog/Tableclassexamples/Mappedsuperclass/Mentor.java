package com.example.productcatlog.Tableclassexamples.Mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class Mentor extends User {
    private Integer NumberOfHours;
}

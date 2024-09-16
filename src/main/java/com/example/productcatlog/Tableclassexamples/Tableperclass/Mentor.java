package com.example.productcatlog.Tableclassexamples.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User {

    private Integer NumberOfHours;
}

package com.example.productcatlog.Tableclassexamples.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="si_mentor")
@DiscriminatorValue(value="3")
public class Mentor extends User {

    private Integer NumberOfHours;
}

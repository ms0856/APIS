package com.example.productcatlog.Tableclassexamples.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="si_ta")
@DiscriminatorValue(value="1")
public class ta extends User {
    private Double ratings;
}

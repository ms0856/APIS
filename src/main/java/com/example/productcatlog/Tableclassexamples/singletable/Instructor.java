package com.example.productcatlog.Tableclassexamples.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="si_instrucor")
@DiscriminatorValue(value="2")
public class Instructor extends User {

    private String company;
}

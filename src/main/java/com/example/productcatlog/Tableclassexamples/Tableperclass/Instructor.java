package com.example.productcatlog.Tableclassexamples.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instrucor")
public class Instructor extends User {

    private String company;
}

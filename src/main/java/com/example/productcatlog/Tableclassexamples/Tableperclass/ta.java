package com.example.productcatlog.Tableclassexamples.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class ta extends User{
    private Double ratings;
}

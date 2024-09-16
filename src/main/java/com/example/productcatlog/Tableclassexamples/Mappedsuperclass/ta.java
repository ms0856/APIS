package com.example.productcatlog.Tableclassexamples.Mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class ta extends User{
    private Double ratings;
}

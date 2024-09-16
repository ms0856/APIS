package com.example.productcatlog.Tableclassexamples.Joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class ta extends User {
    private Double ratings;
}

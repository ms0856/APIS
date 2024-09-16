package com.example.productcatlog.Tableclassexamples.Joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_instrucor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {

    private String company;
}

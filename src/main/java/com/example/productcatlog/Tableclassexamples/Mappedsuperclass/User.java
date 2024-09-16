package com.example.productcatlog.Tableclassexamples.Mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
    @Id
    private Integer id;
    private String name;
}

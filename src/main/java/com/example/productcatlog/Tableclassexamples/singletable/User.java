package com.example.productcatlog.Tableclassexamples.singletable;

import jakarta.persistence.*;

@Entity(name="si_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_type", discriminatorType=DiscriminatorType.INTEGER)
public class User {
    @Id
    private Long id;
    private String name;
}

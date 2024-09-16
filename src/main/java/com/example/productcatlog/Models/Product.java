package com.example.productcatlog.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String name;
    private String description;
    private Double price;
    private String ImageUrl;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}

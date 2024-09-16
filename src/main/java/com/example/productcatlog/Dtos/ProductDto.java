package com.example.productcatlog.Dtos;

import com.example.productcatlog.Models.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String ImageUrl;
    private CategoryDto category;
}

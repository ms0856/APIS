package com.example.productcatlog.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public abstract class BaseModel {

    private Long id;
    private Date CreatedAt;
    private Date UpdatedAt;
    private Status status;

}

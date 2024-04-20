package dev.sandeep.EcomProductServiceDec23.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}

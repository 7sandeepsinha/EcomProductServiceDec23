package dev.sandeep.EcomProductServiceDec23.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_PRODUCT")
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageURL;
    private double rating;
}

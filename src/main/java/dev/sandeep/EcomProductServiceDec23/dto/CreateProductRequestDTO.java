package dev.sandeep.EcomProductServiceDec23.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private String imageURL;
    private UUID categoryId;
}

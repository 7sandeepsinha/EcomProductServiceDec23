package dev.sandeep.EcomProductServiceDec23.dto;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> products;
}

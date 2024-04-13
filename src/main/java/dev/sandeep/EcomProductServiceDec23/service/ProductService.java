package dev.sandeep.EcomProductServiceDec23.service;

import dev.sandeep.EcomProductServiceDec23.dto.FakeStoreProductResponseDTO;
import dev.sandeep.EcomProductServiceDec23.entity.Product;
import dev.sandeep.EcomProductServiceDec23.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}

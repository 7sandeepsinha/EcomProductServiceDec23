package dev.sandeep.EcomProductServiceDec23.service;

import dev.sandeep.EcomProductServiceDec23.client.FakeStoreClient;
import dev.sandeep.EcomProductServiceDec23.dto.fakeStoreDTOs.FakeStoreProductResponseDTO;
import dev.sandeep.EcomProductServiceDec23.entity.Product;
import dev.sandeep.EcomProductServiceDec23.exception.NoProductPresentException;
import dev.sandeep.EcomProductServiceDec23.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No products are found");
        }
        return fakeStoreProducts;
    }

    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null){
            throw new ProductNotFoundException("Product not found with id : " + productId);
        }
        return fakeStoreProductResponseDTO;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }
}

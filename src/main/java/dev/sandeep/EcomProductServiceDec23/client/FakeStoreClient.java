package dev.sandeep.EcomProductServiceDec23.client;


import dev.sandeep.EcomProductServiceDec23.dto.FakeStoreCartResponseDTO;
import dev.sandeep.EcomProductServiceDec23.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") // this annotation will, fetch the value from app properties and inject that value to this variable
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        // url - https://fakestoreapi.com/products/id
        String fakeStoreGetProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(fakeStoreGetProductURL, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId){
        // url - https://fakestoreapi.com/carts?userId=1
        if(userId < 1)
            return null;
        String fakeStoreGetCartForUser = fakeStoreAPIBaseUrl.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
}

/*
restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
getForEntity(urlForAPI, the object in which you want the response)
 */

/*
https://fakestoreapi.com/carts?userId=1 -> get cart by userId, and userId is a query param
 */
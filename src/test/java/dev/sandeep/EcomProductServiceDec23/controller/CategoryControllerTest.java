package dev.sandeep.EcomProductServiceDec23.controller;

import dev.sandeep.EcomProductServiceDec23.dto.CategoryResponseDTO;
import dev.sandeep.EcomProductServiceDec23.dto.CreateCategoryRequestDTO;
import dev.sandeep.EcomProductServiceDec23.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required nowadays. It initialises and adds all the required mocks
    }

    @Test
    public void testUpdateCategorySuccess() throws Exception {
        // arrange
        UUID randomUUID = UUID.randomUUID();
        CreateCategoryRequestDTO updateRequestDTO = new CreateCategoryRequestDTO();
        updateRequestDTO.setCategoryName("NewCategoryName");

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(randomUUID);
        categoryResponseDTO.setCategoryName("NewCategoryName");

        Mockito.when(
                categoryService.updateCategory(updateRequestDTO, randomUUID)).
                thenReturn(categoryResponseDTO);

        //act
        ResponseEntity<CategoryResponseDTO> categoryResponseEntity =
                categoryController.updateCategory(randomUUID, updateRequestDTO);

        //assert
        Assertions.assertEquals(categoryResponseDTO, categoryResponseEntity.getBody());
    }

}
/*

    public ResponseEntity<CategoryResponseDTO> updateCategory(UUID categoryId,
    CreateCategoryRequestDTO createCategoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategory(createCategoryRequestDTO, categoryId));
    }
 */
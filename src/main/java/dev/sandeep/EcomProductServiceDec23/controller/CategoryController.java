package dev.sandeep.EcomProductServiceDec23.controller;

import dev.sandeep.EcomProductServiceDec23.dto.CategoryResponseDTO;
import dev.sandeep.EcomProductServiceDec23.dto.CreateCategoryRequestDTO;
import dev.sandeep.EcomProductServiceDec23.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id")UUID categoryId){

    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){

    }

}

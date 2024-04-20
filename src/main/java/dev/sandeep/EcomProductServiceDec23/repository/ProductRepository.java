package dev.sandeep.EcomProductServiceDec23.repository;

import dev.sandeep.EcomProductServiceDec23.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

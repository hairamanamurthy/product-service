package com.example.ProductService.repositories;

import com.example.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findFirstByNameAndDescription(String name,String description);
   // Product findByDescription(String description);
   // List<Product> findAll();
  Product findById(long id);
   // List<Product> findAllCategory(String category);
    Product deleteById(long id);
    List<Product> findAll();


}

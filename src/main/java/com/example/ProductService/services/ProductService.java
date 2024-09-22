package com.example.ProductService.services;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;
    public Product cerateProduct(String name,String category, String description,double price);
    public Product getDBProductByID(long id) throws ProductNotFoundException;
    public String deleteDbProductById(long id) throws ProductNotFoundException;
    public List<Product> getAllProductsFromDB();
    public Product updateProductFromDb(long id,String name,String category, String description,double price) throws ProductNotFoundException;
}
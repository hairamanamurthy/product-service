package com.example.ProductService.dtos;

import lombok.Data;

@Data
public class UpdateProductRequestDto {
    long id;
    String name;
    String category;
    String description;
    double price;

}

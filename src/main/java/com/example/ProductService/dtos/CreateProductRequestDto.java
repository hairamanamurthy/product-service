package com.example.ProductService.dtos;

import lombok.Data;
import org.apache.catalina.webresources.StandardRoot;
@Data
public class CreateProductRequestDto {
    String name;
    String category;
    String description;
    double price;
}

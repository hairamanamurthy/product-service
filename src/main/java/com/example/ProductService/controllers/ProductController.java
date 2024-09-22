package com.example.ProductService.controllers;

import com.example.ProductService.dtos.CreateProductRequestDto;
import com.example.ProductService.dtos.UpdateProductRequestDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.List;

@RestController
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("dbImple")
    private ProductService productService;
    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
       // ResponseEntity<Product> responseEntity;
//        if(productId<0 || productId>20){
////            System.out.println("not an valid product id");
//            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//        }
        Product product=productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> getProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));

    }
    @PostMapping("/products")
    public Product createProductToDB(@RequestBody CreateProductRequestDto requestDto){
        System.out.println(requestDto);
        return productService.cerateProduct(requestDto.getName(),requestDto.getCategory(),requestDto.getDescription(),requestDto.getPrice());
    }

    @GetMapping("/productss/{id}")
    public Product getDbProductById(@PathVariable("id") long productid) throws ProductNotFoundException{
        return productService.getDBProductByID(productid);
    }

    @DeleteMapping("productss/{id}")
    public String deleteDbProductByid(@PathVariable("id") long id) throws ProductNotFoundException{
        return productService.deleteDbProductById(id);
    }
    @GetMapping("/products")
    public List<Product> getAllProductsDB(){
        return productService.getAllProductsFromDB();
    }
    @PutMapping("/products/{id}")
    public Product productUpdate(@PathVariable("id" ) long id, @RequestBody UpdateProductRequestDto updateRequest) throws ProductNotFoundException{
       return productService.updateProductFromDb(id,updateRequest.getName(),updateRequest.getCategory(),updateRequest.getDescription(),updateRequest.getPrice());
    }
}

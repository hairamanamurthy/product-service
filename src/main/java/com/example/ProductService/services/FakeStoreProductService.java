package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.models.ProductRating;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(long id) throws ProductNotFoundException{
        String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject(url, FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw  new ProductNotFoundException("Product with given id:"+id+" Not found");
        }
        Product product= converFakeStoreProductToProduct(fakeStoreProductDto);
        return product;
    }

    @Override
    public Product cerateProduct(String name, String category, String description, double price) {
        return null;
    }

    @Override
    public Product getDBProductByID(long id) {
        return null;
    }

    @Override
    public String deleteDbProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProductsFromDB() {
        return List.of();
    }

    @Override
    public Product updateProductFromDb(long id, String name, String category, String description, double price) throws ProductNotFoundException{
        return null;
    }


    private Product converFakeStoreProductToProduct(FakeStoreProductDto dto){
        Product product=new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
       // product.setRating(dto.getRating());

        return product;
    }
}

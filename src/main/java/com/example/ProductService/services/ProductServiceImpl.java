package com.example.ProductService.services;

import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service("dbImple")
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product cerateProduct(String name, String category, String description, double price) {
        Product p=productRepository.findFirstByNameAndDescription(name,description);
        if(p!=null){
            return p;
        }
        Product product=new Product();
        product.setCategory(category);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product =productRepository.save(product);
        System.out.println(product.getId());
        return product;
    }

    @Override
    public Product getDBProductByID(long id) throws ProductNotFoundException{
        Product p=productRepository.findById(id);
        if(p==null){
            throw new ProductNotFoundException("The given product id:"+id+" not found");
        }

        return p;
    }

    @Override
    public String deleteDbProductById(long id) throws ProductNotFoundException {
        Product p=productRepository.findById(id);
        if(p==null){
            throw new ProductNotFoundException("The given product id:"+id+" not found");
        }
        Product p1=productRepository.deleteById(id);
        System.out.println("Product with id:"+ id +" was deleted successful");

        return "Product with id:"+ id +" was deleted successful";
    }

    @Override
    public List<Product> getAllProductsFromDB() {
        List<Product> lp=productRepository.findAll();

        return lp;
    }

    @Override
    public Product updateProductFromDb(long id,String name,String categroy,String description,double price) throws ProductNotFoundException{
        Product p=productRepository.findById(id);
        if(p==null){
            throw new ProductNotFoundException("The given product id:"+id+" not found");
        }
        else{
            p.setName(name);
            p.setCategory(categroy);
            p.setDescription(description);
            p.setPrice(price);
            p=productRepository.save(p);
        }

        return p;
    }


}

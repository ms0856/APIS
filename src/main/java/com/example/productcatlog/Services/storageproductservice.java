package com.example.productcatlog.Services;

import com.example.productcatlog.Models.Product;
import com.example.productcatlog.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Primary
public class storageproductservice implements IproductService {

    @Autowired
   private ProductRepo productRepo;
    @Override
    public Product getProductById(Long productid) {
        Optional<Product> product = productRepo.findById(productid);
        if(product.isPresent())
        {
            return product.get();
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product ReplaceProduct(Product product, Long productId) {
        return null;
    }
}

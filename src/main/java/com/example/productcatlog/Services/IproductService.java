package com.example.productcatlog.Services;

import com.example.productcatlog.Dtos.ProductDto;
import com.example.productcatlog.Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IproductService {

    public Product getProductById( Long productid);
    public Product createProduct( Product product);
    public List<Product> getProducts();
    public Product ReplaceProduct( Product product,Long productId);
}

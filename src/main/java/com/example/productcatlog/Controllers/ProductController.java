package com.example.productcatlog.Controllers;

import com.example.productcatlog.Dtos.CategoryDto;
import com.example.productcatlog.Dtos.FakeStoreProductDto;
import com.example.productcatlog.Dtos.ProductDto;
import com.example.productcatlog.Models.Category;
import com.example.productcatlog.Models.Product;
import com.example.productcatlog.Services.IproductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private IproductService productService;
    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id")  Long productid) {

        try{
         if(productid<=0)
         {
             throw new IllegalArgumentException("Invalid productid");
         }
        Product product= productService.getProductById(productid);
        ProductDto productDto= getProductDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        catch (IllegalArgumentException exception)
        {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {

        Product input= getProduct(productDto);
        Product product= productService.createProduct(input);
        return getProductDto(product);
    }

   @PutMapping("/products/{id}")
    public ProductDto ReplaceProduct(@PathVariable("id") Long id ,@RequestBody ProductDto productDto)
    {
        Product input=getProduct(productDto);
      Product product= productService.ReplaceProduct(input, id);
      return getProductDto(product);
    }
    private Product getProduct(ProductDto productDto){

        Product product=new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        if(productDto.getCategory()!=null){
            Category category=new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;}
    private ProductDto getProductDto(Product product){

        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory()!=null){
        CategoryDto category=new CategoryDto();
        category.setId(product.getCategory().getId());
        category.setName(product.getCategory().getName());
        category.setDescription(product.getCategory().getDescription());
        productDto.setCategory(category);
        }
        return productDto;
    }
}
